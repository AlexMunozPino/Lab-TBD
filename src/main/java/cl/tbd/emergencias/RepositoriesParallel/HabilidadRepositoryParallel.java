package cl.tbd.emergencias.RepositoriesParallel;

import cl.tbd.emergencias.Models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Repository
public class HabilidadRepositoryParallel {
    @Autowired
    @Qualifier("parallel")
    private List<Sql2o> sql2o_parallel;

    public void insert(Habilidad habilidad) {
        int db = hash(habilidad);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("insert into habilidad (id, descrip) " +
                    "values (:id, :descrip)")
                    .addParameter("id", habilidad.getId())
                    .addParameter("descrip", habilidad.getDescrip())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Habilidad getOneById(Integer id) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(sql2o_parallel.size());
            List<Habilidad>[] results = new ArrayList[sql2o_parallel.size()];
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                final int db = i;
                results[i] = new ArrayList<Habilidad>();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try (Connection conn = sql2o_parallel.get(db).open()) {
                            results[db] = conn.createQuery("select * from habilidad where id = " + id)
                                    .executeAndFetch(Habilidad.class);
                        }
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(24 * 3600, TimeUnit.SECONDS);
            List<Habilidad> merged = new ArrayList<Habilidad>();
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                merged.addAll(results[i]);
            }
            return merged.get(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Habilidad> getAll() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(sql2o_parallel.size());
            List<Habilidad>[] results = new ArrayList[sql2o_parallel.size()];
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                final int db = i;
                results[i] = new ArrayList<Habilidad>();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try (Connection conn = sql2o_parallel.get(db).open()) {
                            results[db] = conn.createQuery("select * from habilidad")
                                    .executeAndFetch(Habilidad.class);
                        }
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(24 * 3600, TimeUnit.SECONDS);
            List<Habilidad> merged = new ArrayList<Habilidad>();
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                merged.addAll(results[i]);
            }
            return merged;
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(Habilidad habilidad, Integer id) {
        int db = hash(habilidad);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("update habilidad " +
                    "set id=:id, descrip=:descrip " +
                    "where id=:id")
                    .addParameter("id", habilidad.getId())
                    .addParameter("descrip", habilidad.getDescrip())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Integer id) {
        int db = hash(id);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("delete from habilidad where id =" + id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int hash(int id) {
        return id % 3;
    }

    public int hash(Habilidad habilidad) {
        return habilidad.getId() % 3;
    }
}
