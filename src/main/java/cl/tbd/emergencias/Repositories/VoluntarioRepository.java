package cl.tbd.emergencias.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.emergencias.Models.Voluntario;

public class VoluntarioRepository implements RepositoryInterface<Voluntario> {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Voluntario> getAll() {
        List<Voluntario> lista = new ArrayList<Voluntario>();
        String sql = "SELECT * FROM  voluntario";
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery(sql).executeAndFetch(Voluntario.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
     }

     public Voluntario getOneById(Integer id) {

        String sql = "SELECT * FROM  voluntario "+ "WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetchFirst(Voluntario.class);
        }

     }

     @Override
    public Integer create(Voluntario obj) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer update(Voluntario obj) {
        return null;
    }

    public List<Voluntario> getAllByEmergenciaID(Integer emergencyId){
        List<Voluntario> lista = new ArrayList<Voluntario>();
        String sql = "SELECT V.id, V.nombre FROM   voluntario V, tarea T, emergencia E, ranking R "+
                        "WHERE E.id = :emergencyId "+
                        "AND E.id = T.id_emergencia "+
                        "AND T.id = R.id_tarea "+
                        "AND R.id_voluntario = V.id";
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery(sql).addParameter("emergencyId", emergencyId).executeAndFetch(Voluntario.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
}