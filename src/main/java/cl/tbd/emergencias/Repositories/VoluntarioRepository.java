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
    
}