package cl.tbd.emergencias.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.emergencias.Models.Voluntario;
import cl.tbd.emergencias.Services.VoluntarioService;


@RestController
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @CrossOrigin("*")
    @GetMapping("/voluntario")
    public List<Voluntario> getMethodName() {
        return voluntarioService.getAll();
    }

    @CrossOrigin("*")
    @GetMapping("voluntario/emergencia/{emergencyId}")
    public List<Voluntario> getVoluntariosOfEmergencias(@PathVariable(value = "emergencyId") String emergencyId ){
        return voluntarioService.getAllByEmergenciaID(Integer.parseInt(emergencyId));
    }

    @CrossOrigin("*")
    @GetMapping("voluntario/nombre-emergencia/{emergencyName}")
    public List<Voluntario> getVoluntariosOfEmergenciasByName(@PathVariable(value = "emergencyName") String emergencyName ){
        return voluntarioService.getAllByEmergenciaName(emergencyName);
    }

    @CrossOrigin("*")
    @GetMapping("voluntario/habilidad/{habilidadId}")
    public List<Voluntario> getVoluntariosOfHabilidad (@PathVariable(value = "habilidadId") String habilidadId ){
        return voluntarioService.getAllByHabilidadID(Integer.parseInt(habilidadId));
    }
    
    
}
