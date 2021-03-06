package cl.tbd.emergencias.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.tbd.emergencias.Models.Vol_distancia;
import cl.tbd.emergencias.Models.Voluntario;
import cl.tbd.emergencias.Repositories.VoluntarioRepository;

public class VoluntarioServiceImpl implements VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Override
    public List<Voluntario> getAll() {
        return voluntarioRepository.getAll();
    }


    @Override
    public Voluntario getOneById(Integer id){
        return voluntarioRepository.getOneById(id);
    }


    @Override
    public List<Voluntario> getAllByEmergenciaID(Integer emergencyId){
        return voluntarioRepository.getAllByEmergenciaID(emergencyId);
    }

    @Override
    public List<Voluntario> getAllByEmergenciaName(String emergencyName){
        return voluntarioRepository.getAllByEmergenciaName(emergencyName);
    }

    @Override
    public List<Voluntario> getAllByHabilidad(String habilidadNombre){
        return voluntarioRepository.getAllByHabilidad(habilidadNombre);
    }
    @Override
    public List<Voluntario> getAllByEmergenciaHabilidad(String emergencyName, Integer habilidadId){
        return voluntarioRepository.getAllByEmergenciaHabilidad(emergencyName, habilidadId);
    }

    @Override
    public List<Vol_distancia> getUsersByEmergencydistance(Integer emergenciaId){
        return voluntarioRepository.getUsersByEmergencydistance(emergenciaId);
    }

}