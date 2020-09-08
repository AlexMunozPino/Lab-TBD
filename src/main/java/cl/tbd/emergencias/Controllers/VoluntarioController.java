package cl.tbd.emergencias.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.emergencias.Models.Vol_distancia;
import cl.tbd.emergencias.Models.Voluntario;
import cl.tbd.emergencias.Services.VoluntarioService;


@RestController
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @CrossOrigin("*")
    @GetMapping("/voluntario")
    //Método para obtener toda la información contenida en la tabla Voluntario
    public List<Voluntario> getMethodName() {
        return voluntarioService.getAll();
    }

    @CrossOrigin("*")
    @GetMapping("voluntario/emergencia/{emergencyId}")
    //Método para obtener todos los voluntarios de una emergencia especifica segun su Id
    public List<Voluntario> getVoluntariosOfEmergencias(@PathVariable(value = "emergencyId") String emergencyId ){
        return voluntarioService.getAllByEmergenciaID(Integer.parseInt(emergencyId));
    }

    @CrossOrigin("*")
    @GetMapping("voluntario/nombre-emergencia/{emergencyName}")
    //Método para obtener todos los voluntarios de una emergencia especifica segun su nombre
    public List<Voluntario> getVoluntariosOfEmergenciasByName(@PathVariable(value = "emergencyName") String emergencyName ){
        return voluntarioService.getAllByEmergenciaName(emergencyName);
    }

    @CrossOrigin("*")
    @GetMapping("voluntario/habilidad/{habilidadNombre}")
    //Método para obtener todos los voluntarios con una habilidad especifica segun su nombre
    public List<Voluntario> getVoluntariosOfHabilidad (@PathVariable(value = "habilidadNombre") String habilidadNombre ){
        return voluntarioService.getAllByHabilidad(habilidadNombre);
    }

    @CrossOrigin("*")
    @GetMapping("voluntario/emergencia/{emergencyName}/habilidad/{habilidadId}")
    //Método para obtener todos los voluntarios con una habilidad especifica segun su Id y segun el nombre de una emergencia
    public List<Voluntario> getVoluntariosOfEmeHabilidad (@PathVariable(value = "emergencyName") String emergencyName,
                                                          @PathVariable(value = "habilidadId") String habilidadId ){
        return voluntarioService.getAllByEmergenciaHabilidad(emergencyName, Integer.parseInt(habilidadId));
    }

    
    //Método para obtener todos los voluntarios con una habilidad especifica segun su Id y segun el nombre de una emergencia
    @CrossOrigin("*")
    @GetMapping("/voluntario/dist/{emergencyId}")
    public List<Vol_distancia> getVoluntariosByEmergencydistance (@PathVariable(value = "emergencyId") String emergencyId){
        return voluntarioService.getUsersByEmergencydistance(Integer.parseInt(emergencyId));
    }

}
