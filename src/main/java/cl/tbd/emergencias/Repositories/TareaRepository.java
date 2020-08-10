package cl.tbd.emergencias.Repositories;

import cl.tbd.emergencias.Models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepository implements RepositoryInterface<Tarea>{
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea> getAll() {
        List<Tarea> lista = new ArrayList<Tarea>();
        String sql = "SELECT * FROM  tarea";
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery(sql).executeAndFetch(Tarea.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
     }

     @Override
    public Tarea getOneById(Integer id) {
        Tarea tarea = null;
        try(Connection connection = sql2o.open())
        {
            tarea = connection.createQuery("SELECT * FROM tarea WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tarea;
    }

    // Agregar más tarde
    @Override
    public Integer create(Tarea obj) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer update(Tarea obj) {
        return null;
    }

}