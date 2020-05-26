package cl.tbd.emergencias.Models;

public class Tarea_habilidad {
    
    private Integer id;
    private Integer id_tarea;
    private Integer id_emehab;

    public Tarea_habilidad (Integer id, Integer id_tarea, Integer id_emehab){
        this.id = id;
        this.id_tarea = id_tarea;
        this.id_emehab = id_emehab;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id = id_tarea;
    }

    public Integer getId_emehab() {
        return id_emehab;
    }

    public void setId_emehab(Integer id_emehab) {
        this.id = id_emehab;
    }
    
}
