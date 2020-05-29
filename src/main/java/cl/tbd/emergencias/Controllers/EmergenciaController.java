package cl.tbd.emergencias.Controllers;

import cl.tbd.emergencias.Models.Emergencia;
import cl.tbd.emergencias.Services.EmergenciaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmergenciaController {

    private EmergenciaService emergenciaService;


    @GetMapping("/emergencia")
    public List<Emergencia> getAll(){
        return this.emergenciaService.getAll();
    }

    @GetMapping("/emergencia/{id}")
    public Emergencia getOneById(@PathVariable(value="id") String id)
    {
        return this.emergenciaService.getOneById(Integer.parseInt(id));
    }
}
