package cl.tbd.emergencias.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.tbd.emergencias.Models.Habilidad;
import cl.tbd.emergencias.Repositories.HabilidadRepository;

public class HabilidadServiceImpl implements HabilidadService{

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public List<Habilidad> getAll() {
        return habilidadRepository.getAll();
    }

    @Override
    public Habilidad getOneById(Integer id){
        return habilidadRepository.getOneById(id);
    }

}