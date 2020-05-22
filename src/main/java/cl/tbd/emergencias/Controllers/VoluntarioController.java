package cl.tbd.emergencias.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cl.tbd.emergencias.Models.Voluntario;
import cl.tbd.emergencias.Services.VoluntarioService;


@Controller
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @GetMapping("voluntary")
    public List<Voluntario> getMethodName() {
        return voluntarioService.getAll();
    }
    
    
}