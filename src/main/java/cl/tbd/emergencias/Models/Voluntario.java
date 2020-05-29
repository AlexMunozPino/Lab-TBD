package cl.tbd.emergencias.Models;

import java.util.Date;

public class Voluntario {

    private Integer id;

    private String nombre;

    private Date fnacimiento;


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

    public Date getFnacimiento() {
        return this.fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }



    public Voluntario(String nombre, Date fnacimiento) {
        this.nombre = nombre;
        this.fnacimiento = fnacimiento;
    }

}