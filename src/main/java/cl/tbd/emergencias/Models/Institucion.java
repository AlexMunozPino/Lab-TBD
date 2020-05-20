package cl.tbd.emergencias.Models;

public class Institucion {
    private Integer id;
    private String nombre;
    private String descrip;

    public Institucion (Integer id, String nombre, String descrip) {
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
