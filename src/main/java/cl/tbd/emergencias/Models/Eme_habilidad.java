package cl.tbd.emergencias.Models;
//Se define el modelo para la tabla Eme_habilidad
public class Eme_habilidad {
    private Integer id;
    private Integer id_emergencia;
    private Integer id_habilidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getIdEmergencia() {
        return id_emergencia;
    }

    public void setIdEmergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Integer getIdHabilidad() {
        return id_habilidad;
    }

    public void SetIdHabilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }


    public Eme_habilidad(Integer id_emergencia, Integer id_habilidad) {
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }
}