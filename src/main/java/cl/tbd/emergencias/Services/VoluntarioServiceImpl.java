package cl.tbd.emergencias.Services;

import java.util.List;


import cl.tbd.emergencias.Models.Voluntario;
import cl.tbd.emergencias.Repositories.VoluntarioRepository;

public class VoluntarioServiceImpl implements VoluntarioService {

    private VoluntarioRepository voluntarioRepository;

    @Override
    public List<Voluntario> getAll() {
        return voluntarioRepository.getAll();
    }


    @Override
    public Voluntario getOneById(Integer id){
        return voluntarioRepository.getOneById(id);
    }
}