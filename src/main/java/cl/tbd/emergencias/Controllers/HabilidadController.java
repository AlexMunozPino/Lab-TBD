package cl.tbd.emergencias.Controllers;

import cl.tbd.emergencias.Models.Habilidad;
import cl.tbd.emergencias.Services.HabilidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;


    @GetMapping("/habilidad")
    //Método para obtener toda la información contenida en la tabla Habilidad
    public List<Habilidad> getAll(){
        return this.habilidadService.getAll();
    }

    @GetMapping("/habilidad/{id}")
    //Método para obtener una habilidad específica según su id
    public Habilidad getOneById(@PathVariable(value="id") String id)
    {
        return this.habilidadService.getOneById(Integer.parseInt(id));
    }


}