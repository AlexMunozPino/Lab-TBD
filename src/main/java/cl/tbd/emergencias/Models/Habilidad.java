package cl.tbd.emergencias.Models;

//Se define el modelo para la tabla Habilidad
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

    public String getDescrip() {
        return this.descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

}
