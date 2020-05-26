package cl.tbd.emergencias.Services;

import java.util.List;

import cl.tbd.emergencias.Models.Emergencia;
import cl.tbd.emergencias.Repositories.EmergenciaRepository;

public class EmergenciaServiceImpl implements EmergenciaService{

    private EmergenciaRepository emergenciaRepository;

    @Override
    public List<Emergencia> getAll() {
        return emergenciaRepository.getAll();
    }


    @Override
    public Emergencia getOneById(Integer id){
        return emergenciaRepository.getOneById(id);
    }
    
}