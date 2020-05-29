package cl.tbd.emergencias.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.emergencias.Models.Voluntario;
import cl.tbd.emergencias.Services.VoluntarioService;


@RestController
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @GetMapping("/voluntario")
    public List<Voluntario> getMethodName() {
        return voluntarioService.getAll();
    }

    @GetMapping("voluntario/emergencia/{emergencyId}")
    public List<Voluntario> getVoluntariosOfEmergencias(@PathVariable(value = "emergencyId") String emergencyId ){
        System.out.println(emergencyId);
        return voluntarioService.getAllByEmergenciaID(Integer.parseInt(emergencyId));
    }
    
    
}