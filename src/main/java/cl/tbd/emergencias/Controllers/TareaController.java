package cl.tbd.emergencias.Controllers;

import cl.tbd.emergencias.Models.Tarea;
import cl.tbd.emergencias.Services.TareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class TareaController {

    @Autowired
    private TareaService tareaService;

    
    @GetMapping("/tarea")
    //Método para obtener toda la información contenida en la tabla Tarea
    public List<Tarea> getAll(){
        return this.tareaService.getAll();
    }

    @GetMapping("/tarea/{id}")
    //Método para obtener una tarea específica según su id
    public Tarea getOneById(@PathVariable(value = "id") String id){
        return this.tareaService.getOneById(Integer.parseInt(id));
    }
    
}