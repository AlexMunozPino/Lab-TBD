package cl.tbd.emergencias.Controllers;

import cl.tbd.emergencias.Models.LogTarea;

import cl.tbd.emergencias.Services.LogTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogTareaController {

    @Autowired
    private LogTareaService logTareaService;

    @CrossOrigin("*")
    @GetMapping("/logtarea")
    public List<LogTarea> getAll(){
        return this.logTareaService.getAll();
    }

    @CrossOrigin("*")
    @GetMapping("/logtarea/{id}")
    public LogTarea getOneById(@PathVariable(value="id") String id)
    {
        return this.logTareaService.getOneById(Integer.parseInt(id));
    }

    @CrossOrigin("*")
    @GetMapping("/logtarea/addrandom")
    public boolean insertRandomWithCurrentDate(){
        return this.logTareaService.insertRandomWithCurrentDate();
    };
}
