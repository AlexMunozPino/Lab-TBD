package cl.tbd.emergencias.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.emergencias.Models.Vol_distancia;
import cl.tbd.emergencias.Models.Voluntario;

public class VoluntarioRepository implements RepositoryInterface<Voluntario> {

    @Autowired
    private Sql2o sql2o;

    @Override
    //Método para obtener toda la información contenida en la tabla Voluntario
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
    //Método para obtener un voluntario específico según su id
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
    //Método para obtener todos los voluntarios de una emergencia especifica segun su Id
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
    //Método para obtener todos los voluntarios de una emergencia especifica segun su nombre
    public List<Voluntario> getAllByEmergenciaName(String emergencyName){
        List<Voluntario> lista = new ArrayList<Voluntario>();
        String sql = "SELECT DISTINCT V.id, V.nombre, V.fnacimiento FROM   voluntario V, tarea T, emergencia E, ranking R "+
                        "WHERE E.nombre = :emergencyName "+
                        "AND E.id = T.id_emergencia "+
                        "AND T.id = R.id_tarea "+
                        "AND R.id_voluntario = V.id "+
                        "ORDER BY V.id ASC";
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery(sql).addParameter("emergencyName", emergencyName).executeAndFetch(Voluntario.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    //Método para obtener todos los voluntarios con una habilidad especifica segun su nombre
    public List<Voluntario> getAllByHabilidad( String habilidadNombre){
        System.out.println(habilidadNombre);
        List<Voluntario> lista = new ArrayList<Voluntario>();
        String sql = "SELECT DISTINCT V.id, V.nombre, V.fnacimiento " +
                "FROM voluntario V, habilidad H, vol_habilidad VH " +
                "WHERE H.descrip =  :habilidadNombre "+
                "AND VH.id_habilidad = H.id " +
                "AND V.id = VH.id_voluntario " +
                "ORDER BY V.id ASC";
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery(sql).addParameter("habilidadNombre", habilidadNombre).executeAndFetch(Voluntario.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    //Método para obtener todos los voluntarios con una habilidad especifica segun su Id y segun el nombre de una emergencia
    public List<Voluntario> getAllByEmergenciaHabilidad(String emergencyName, Integer habilidadId){
        List<Voluntario> lista = new ArrayList<Voluntario>();
        String sql = "SELECT DISTINCT V.nombre " +
                "FROM voluntario V " +
                "INNER JOIN vol_habilidad VH on V.id = VH.id_voluntario " +
                "and VH.id_habilidad = :habilidadId " +
                "WHERE V.id IN " +
                "(SELECT V.id FROM   voluntario V, tarea T, emergencia E, ranking R "+
                "WHERE E.nombre = :emergencyName "+
                "AND E.id = T.id_emergencia "+
                "AND T.id = R.id_tarea "+
                "AND R.id_voluntario = V.id)";
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery(sql).addParameter("habilidadId", habilidadId).addParameter("emergencyName", emergencyName).executeAndFetch(Voluntario.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<Vol_distancia> getUsersByEmergencydistance(Integer emergenciaId){
        List<Vol_distancia> lista = new ArrayList<Vol_distancia>();
        String sql = "SELECT v.id AS id,v.nombre AS nombre, v.apellido AS apellido, v.longitude AS longitude, v.latitude AS latitude," +
                "st_distance(ST_GeomFromText(CONCAT('POINT(',v.longitude,' ',v.latitude,')'),4326)," +
                "e.location::geography) AS distancia FROM voluntario v, emergencia e WHERE e.id = :emergenciaId ORDER BY distancia asc;";
        try(Connection conn = sql2o.open()) {
            lista = conn.createQuery(sql).addParameter("emergenciaId", emergenciaId).executeAndFetch(Vol_distancia.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    } 
}

	
