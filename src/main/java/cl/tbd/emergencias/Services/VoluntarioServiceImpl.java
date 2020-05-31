package cl.tbd.emergencias.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Voluntario> getAllByHabilidadID(Integer habilidadId){
        return voluntarioRepository.getAllByHabilidadID(habilidadId);
    }


}