package cl.tbd.emergencias.Repositories;

import cl.tbd.emergencias.Models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmergenciaRepository implements RepositoryInterface<Emergencia>{
    @Autowired
    private Sql2o sql2o;

    @Override
    //Método para obtener toda la información contenida en la tabla Emergencia
    public List<Emergencia> getAll() {
        List<Emergencia> lista = new ArrayList<Emergencia>();
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery("SELECT id, nombre, descrip, finicio, ffin, id_institucion, st_x(st_astext(location)) AS longitude, st_y(st_astext(location)) AS latitude FROM  emergencia")
                    .executeAndFetch(Emergencia.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    //Método para obtener una emergencia específica según su id
    public Emergencia getOneById(Integer id) {
        Emergencia emergencia = null;
        try(Connection connection = sql2o.open())
        {
            emergencia = connection.createQuery("SELECT * FROM emergencia WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emergencia;
    }

    // Agregar más tarde
    @Override
    public Integer create(Emergencia obj) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer update(Emergencia obj) {
        return null;
    }
}