package cl.tbd.emergencias.RepositoriesParallel;

import cl.tbd.emergencias.Models.Vol_habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Repository
public class VoluntarioHabilidadRepositoryParallel {

    @Autowired
    @Qualifier("parallel")
    private List<Sql2o> sql2o_parallel;

    public void insert(Vol_habilidad vol_habilidad) {
        int id = getMaxId() + 1;
        int db = hash(id);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("insert into vol_habilidad (id, id_voluntario, id_habilidad)" +
                    "values (:id, :id_voluntario, :id_habilidad)")
                    .addParameter("id", id)
                    .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Vol_habilidad getOneById(Integer id) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(sql2o_parallel.size());
            List<Vol_habilidad>[] results = new ArrayList[sql2o_parallel.size()];
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                final int db = i;
                results[i] = new ArrayList<Vol_habilidad>();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try (Connection conn = sql2o_parallel.get(db).open()) {
                            results[db] = conn.createQuery("select * from vol_habilidad where id = " + id)
                                    .executeAndFetch(Vol_habilidad.class);
                        }
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(24 * 3600, TimeUnit.SECONDS);
            List<Vol_habilidad> merged = new ArrayList<Vol_habilidad>();
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

    public List<Vol_habilidad> getAll() {
        System.out.println(sql2o_parallel.size());
        try {
            ExecutorService executor = Executors.newFixedThreadPool(sql2o_parallel.size());
            List<Vol_habilidad>[] results = new ArrayList[sql2o_parallel.size()];
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                final int db = i;
                results[i] = new ArrayList<Vol_habilidad>();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try (Connection conn = sql2o_parallel.get(db).open()) {
                            results[db] = conn.createQuery("select * from vol_habilidad")
                                    .executeAndFetch(Vol_habilidad.class);
                        }
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(24 * 3600, TimeUnit.SECONDS);
            List<Vol_habilidad> merged = new ArrayList<Vol_habilidad>();
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

    public void update(Vol_habilidad vol_habilidad, Integer id) {
        int db = hash(vol_habilidad);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("update vol_habilidad " +
                    "set id=:id, id_voluntario=:id_voluntario, id_habilidad=:id_habilidad " +
                    "where id=:id")
                    .addParameter("id", vol_habilidad.getId())
                    .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Integer id) {
        int db = hash(id);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("delete from vol_habilidad where id =" + id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int hash(int id) {
        return id % 3;
    }

    public int hash(Vol_habilidad vol_habilidad) {
        return vol_habilidad.getId() % 3;
    }

    public Integer getMaxId() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(sql2o_parallel.size());
            ArrayList<Integer> results = new ArrayList<>(3);
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                final int db = i;
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try (Connection conn = sql2o_parallel.get(db).open()) {
                            results.add(conn.createQuery("select max(id) from vol_habilidad")
                                    .executeScalar(Integer.class));
                        }
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(24 * 3600, TimeUnit.SECONDS);

            return Collections.max(results);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

}
