package cl.tbd.emergencias.Models;

import java.util.Date;

public class Voluntario {

    private Integer id;

    private String nombre;

    private Date fnacimeinto;


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

    public Date getFnacimeinto() {
        return this.fnacimeinto;
    }

    public void setFnacimeinto(Date fnacimeinto) {
        this.fnacimeinto = fnacimeinto;
    }



    public Voluntario(String nombre, Date fnacimeinto) {
        this.nombre = nombre;
        this.fnacimeinto = fnacimeinto;
    }

}