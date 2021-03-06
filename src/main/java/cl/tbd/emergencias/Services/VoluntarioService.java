package cl.tbd.emergencias.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.tbd.emergencias.Models.Voluntario;
import cl.tbd.emergencias.Models.Vol_distancia;

@Service
public interface VoluntarioService {

    List<Voluntario> getAll();

    Voluntario getOneById(Integer id);

    public List<Voluntario> getAllByEmergenciaID(Integer emergencyId);

    public List<Voluntario> getAllByEmergenciaName(String emergencyName);

    public List<Voluntario> getAllByHabilidad(String habilidadNombre);

    public List<Voluntario> getAllByEmergenciaHabilidad(String emergencyName, Integer idHabilidad);

    public List<Vol_distancia> getUsersByEmergencydistance(Integer emergenciaId);
}