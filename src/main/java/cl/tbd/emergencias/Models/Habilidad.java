package cl.tbd.emergencias.Models;

import java.util.Date;

public class Habilidad {
    private Integer id;
    private String descrip;

    public Habilidad(Integer id, String descrip) {
        this.id = id;
        this.descrip = descrip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
