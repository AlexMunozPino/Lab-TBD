package cl.tbd.emergencias.Models;
//Se define el modelo para la tabla Institucion
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

}
