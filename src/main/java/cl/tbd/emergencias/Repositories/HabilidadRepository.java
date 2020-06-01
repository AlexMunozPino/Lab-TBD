package cl.tbd.emergencias.Repositories;

import cl.tbd.emergencias.Models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HabilidadRepository implements RepositoryInterface<Habilidad>{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Habilidad> getAll() {
        List<Habilidad> lista = new ArrayList<Habilidad>();
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery("SELECT * FROM  habilidad")
                    .executeAndFetch(Habilidad.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Habilidad getOneById(Integer id) {
        Habilidad habilidad = null;
        try(Connection connection = sql2o.open())
        {
            habilidad = connection.createQuery("SELECT * FROM habilidad WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return habilidad;
    }

    // Agregar más tarde
    @Override
    public Integer create(Habilidad obj) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer update(Habilidad obj) {
        return null;
    }

}