package cl.tbd.emergencias.Services;

import java.util.List;

import cl.tbd.emergencias.Models.Emergencia;

public interface EmergenciaService {
    
    List<Emergencia> getAll();

    Emergencia getOneById(Integer id);
    
}