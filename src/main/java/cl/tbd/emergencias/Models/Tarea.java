package cl.tbd.emergencias.Models;

import java.util.Date;
//Se define el modelo para la tabla Tarea
public class Tarea {

    private Integer id;

    private String nombre;

    private String descrip;

    private Integer cant_vol_requeridos;

    private Integer cant_vol_inscritos;

    private Integer id_emergencia;

    private Date finicio;

    private Date ffin;

    private Integer id_estado;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return this.descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Integer getCant_vol_requerido() {
        return this.cant_vol_requeridos;
    }

    public void setCant_vol_requerido(Integer cant_vol_requerido) {
        this.cant_vol_requeridos = cant_vol_requerido;
    }

    public Integer getCant_vol_inscritos() {
        return this.cant_vol_inscritos;
    }

    public void setCant_vol_inscritos(Integer cant_vol_inscritos) {
        this.cant_vol_inscritos = cant_vol_inscritos;
    }

    public Integer getId_emergencia() {
        return this.id_emergencia;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Date getFinicio() {
        return this.finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return this.ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public Integer getId_estado() {
        return this.id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }


    public Tarea(String nombre, String descrip, Integer cant_vol_requeridos, Integer cant_vol_inscritos, Integer id_emergencia, Date finicio, Date ffin, Integer id_estado) {
        this.nombre = nombre;
        this.descrip = descrip;
        this.cant_vol_requeridos = cant_vol_requeridos;
        this.cant_vol_inscritos = cant_vol_inscritos;
        this.id_emergencia = id_emergencia;
        this.finicio = finicio;
        this.ffin = ffin;
        this.id_estado = id_estado;
    }

    
}