package cl.tbd.emergencias.Repositories;


import cl.tbd.emergencias.Models.LogTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class LogTareaRepository implements  RepositoryInterface<LogTarea> {
    @Autowired
    private Sql2o sql2o;

    @Override
    //Método para obtener toda la información contenida en la tabla LogTarea
    public List<LogTarea> getAll() {
        List<LogTarea> lista = new ArrayList<LogTarea>();
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery("SELECT * FROM  log_tarea")
                    .executeAndFetch(LogTarea.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    //Método para obtener una logtarea específica según su id
    public LogTarea getOneById(Integer id) {
        LogTarea logTarea = null;
        try(Connection connection = sql2o.open())
        {
            logTarea = connection.createQuery("SELECT * FROM log_tarea WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(LogTarea.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return logTarea;
    }
    @Override
    public Integer create(LogTarea obj) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer update(LogTarea obj) {
        return null;
    }
    //Método que inserta aleatoriamente con la fecha actual
    public boolean insertRandomWithCurrentDate() {
        Integer lenTarea, lenEstado;
        try(Connection connection = sql2o.open())
        {
            lenTarea = connection.createQuery("SELECT COUNT(*) FROM tarea").executeScalar(Integer.class);
            lenEstado = connection.createQuery("SELECT COUNT(*) FROM estado_tarea").executeScalar(Integer.class);
            connection.createQuery("UPDATE tarea SET id_estado = :id_estado WHERE tarea.id = :tareaId")
                    .addParameter("id_estado", Math.floor(Math.random()*lenEstado))
                    .addParameter("tareaId", Math.floor(Math.random()*lenTarea)).executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
