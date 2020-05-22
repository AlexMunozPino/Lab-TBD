package cl.tbd.emergencias.Controllers;

import cl.tbd.emergencias.Models.Emergencia;
import cl.tbd.emergencias.Repositories.EmergenciaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmergenciaController {
    private final EmergenciaRepository emergenciaRepository;
    EmergenciaController(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencia")
    public List<Emergencia> getAll(){
        return this.emergenciaRepository.getAll();
    }

    @GetMapping("/emergencia/{id}")
    public Emergencia getOneById(@PathVariable(value="id") String id)
    {
        return this.emergenciaRepository.getOneById(Integer.parseInt(id));
    }
}
