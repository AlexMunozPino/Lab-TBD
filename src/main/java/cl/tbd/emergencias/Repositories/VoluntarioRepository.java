package cl.tbd.emergencias.Repositories;

import java.util.List;

import cl.tbd.emergencias.Models.Voluntario;

public interface VoluntarioRepository {

    List<Voluntario> getAll();

    Voluntario getOneById(Integer id);
    
}