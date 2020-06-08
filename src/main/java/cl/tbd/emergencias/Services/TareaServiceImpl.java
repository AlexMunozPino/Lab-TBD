package cl.tbd.emergencias.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.tbd.emergencias.Repositories.TareaRepository;
import cl.tbd.emergencias.Models.Tarea;

public class TareaServiceImpl implements TareaService{
    
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> getAll(){
        return tareaRepository.getAll();
    }

    @Override
    public Tarea getOneById(Integer id){
        return tareaRepository.getOneById(id);
    }
}