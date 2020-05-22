package cl.tbd.eme_tarea.Models;

public class Eme_tarea {
    private Integer id;
    private String descrip;

    public Eme_habildidad(Integer id, String descrip){
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