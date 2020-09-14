package cl.tbd.emergencias.RepositoriesParallel;

import cl.tbd.emergencias.Models.VoluntarioParallel;
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
public class VoluntarioRepositoryParallel {
    @Autowired
    @Qualifier("parallel")
    private List<Sql2o> sql2o_parallel;

    public void insert(VoluntarioParallel voluntario) {
        int db = hash(voluntario);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("insert into voluntario (id, nombre, fnacimiento)" +
                    "values (:id, :nombre, :fnacimiento)")
                    .addParameter("id", voluntario.getId())
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("fnacimiento", voluntario.getFnacimiento())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public VoluntarioParallel getOneById(Integer id) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(sql2o_parallel.size());
            List<VoluntarioParallel>[] results = new ArrayList[sql2o_parallel.size()];
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                final int db = i;
                results[i] = new ArrayList<VoluntarioParallel>();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try (Connection conn = sql2o_parallel.get(db).open()) {
                            results[db] = conn.createQuery("select * from voluntario where id = " + id)
                                    .executeAndFetch(VoluntarioParallel.class);
                        }
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(24 * 3600, TimeUnit.SECONDS);
            List<VoluntarioParallel> merged = new ArrayList<VoluntarioParallel>();
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

    public List<VoluntarioParallel> getAll() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(sql2o_parallel.size());
            List<VoluntarioParallel>[] results = new ArrayList[sql2o_parallel.size()];
            for (int i = 0; i < sql2o_parallel.size(); i++) {
                final int db = i;
                results[i] = new ArrayList<VoluntarioParallel>();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try (Connection conn = sql2o_parallel.get(db).open()) {
                            results[db] = conn.createQuery("select * from voluntario")
                                    .executeAndFetch(VoluntarioParallel.class);
                        }
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(24 * 3600, TimeUnit.SECONDS);
            List<VoluntarioParallel> merged = new ArrayList<VoluntarioParallel>();
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

    public void update(VoluntarioParallel voluntario, Integer id) {
        int db = hash(voluntario);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("update habilidad " +
                    "set id=:id, nombre=:nombre, fnacimiento=:fnacimiento" +
                    "where id=:id")
                    .addParameter("id", voluntario.getId())
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("fnacimiento", voluntario.getFnacimiento())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Integer id) {
        int db = hash(id);
        try (Connection conn = sql2o_parallel.get(db).open()) {
            conn.createQuery("delete from voluntario where id =" + id)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
                            results.add(conn.createQuery("select max(id) from voluntario")
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

    public int hash(int id) {
        return id % 3;
    }

    public int hash(VoluntarioParallel voluntario) {
        return voluntario.getId() % 3;
    }


}
