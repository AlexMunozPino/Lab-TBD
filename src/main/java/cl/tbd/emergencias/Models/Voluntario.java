package cl.tbd.emergencias.Models;

import java.util.Date;
//Se define el modelo para la tabla Voluntario
public class Voluntario {

    private Integer id;

    private String nombre;

    private String apellido;

    private String email;

    private double longitude;

    private double latitude;

    private Date fnacimiento;


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

    public Date getFnacimiento() {
        return this.fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }


    public Voluntario(String nombre, Date fnacimiento) {
        this.nombre = nombre;
        this.fnacimiento = fnacimiento;
    }
    

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }


}