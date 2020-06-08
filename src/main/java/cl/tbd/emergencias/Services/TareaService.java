package cl.tbd.emergencias.Services;

import java.util.List;

import cl.tbd.emergencias.Models.Tarea;

public interface TareaService {
    
    List<Tarea> getAll();

    Tarea getOneById(Integer id);
}