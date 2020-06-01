package cl.tbd.emergencias.Services;

import java.util.List;

import cl.tbd.emergencias.Models.Habilidad;


public interface HabilidadService {
    
    List<Habilidad> getAll();

    Habilidad getOneById(Integer id);

}