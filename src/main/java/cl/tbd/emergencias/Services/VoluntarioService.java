package cl.tbd.emergencias.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.emergencias.Models.Voluntario;

@Service
public interface VoluntarioService {

    List<Voluntario> getAll();

    Voluntario getOneById(Integer id);

    public List<Voluntario> getAllByEmergenciaID(Integer emergencyId);

    public List<Voluntario> getAllByEmergenciaName(String emergencyName);

    public List<Voluntario> getAllByHabilidadID(Integer emergencyId);

}