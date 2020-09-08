package cl.tbd.emergencias.Models;

import java.util.Date;

public class VoluntarioParallel {
    private Integer id;
    private String nombre;
    private Date fnacimiento;

    public VoluntarioParallel(String nombre, Date fnacimiento) {
        this.nombre = nombre;
        this.fnacimiento = fnacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
