package cl.tbd.emergencias.Models;
//Se define el modelo para la tabla Vol_habilidad
public class Vol_habilidad {

    private Integer id;
    private Integer id_voluntario;
    private Integer id_habilidad;


    public Vol_habilidad(Integer id, Integer id_voluntario, Integer id_habilidad) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_voluntario() {
        return this.id_voluntario;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getId_habilidad() {
        return this.id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
    
}