package cl.tbd.emergencias.Repositories;

import cl.tbd.emergencias.Models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RankingRepository implements RepositoryInterface<Ranking>{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> getAll() {
        List<Ranking> lista = new ArrayList<Ranking>();
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery("SELECT * FROM  ranking")
                    .executeAndFetch(Ranking.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Ranking getOneById(Integer id) {
        Ranking ranking = null;
        try(Connection connection = sql2o.open())
        {
            ranking = connection.createQuery("SELECT * FROM ranking WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranking.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ranking;
    }

    @Override
    public Integer create(Ranking obj) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer update(Ranking obj) {
        return null;
    }
}
