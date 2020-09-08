package cl.tbd.emergencias.ControllersParallel;

import cl.tbd.emergencias.Models.VoluntarioParallel;
import cl.tbd.emergencias.RepositoriesParallel.VoluntarioRepositoryParallel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class VoluntarioControllerParallel {
    @Autowired
    private VoluntarioRepositoryParallel repo;

    @CrossOrigin("*")
    @GetMapping("/parallel/voluntario")
    public List<VoluntarioParallel> getAll() {
        return this.repo.getAll();
    }

    @CrossOrigin("*")
    @GetMapping("/parallel/voluntario/{id}")
    public VoluntarioParallel getOneById(@PathVariable(value = "id") String id) {
        return this.repo.getOneById(Integer.parseInt(id));
    }

    @CrossOrigin("*")
    @PostMapping("/parallel/voluntario/{id}/{nombre}/{fnacimiento}")
    public void insert(@PathVariable(value = "id") String id,
                       @PathVariable(value = "nombre") String nombre,
                       @PathVariable(value = "fnacimiento") String fnacimiento) throws ParseException {
        int input_id = Integer.parseInt(id);
        Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(fnacimiento);
        VoluntarioParallel voluntario = new VoluntarioParallel(nombre, fecha);
        voluntario.setId(input_id);
        this.repo.insert(voluntario);
    }

    @CrossOrigin("*")
    @PutMapping("/parallel/voluntario/{id}/{nombre}/{fnacimiento}")
    public void update(@PathVariable(value = "id") String id,
                       @PathVariable(value = "nombre") String nombre,
                       @PathVariable(value = "fnacimiento") String fnacimiento) throws ParseException {
        int input_id = Integer.parseInt(id);
        Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(fnacimiento);
        VoluntarioParallel voluntario = new VoluntarioParallel(nombre, fecha);
        voluntario.setId(input_id);
        this.repo.update(voluntario, input_id);
    }

    @CrossOrigin("*")
    @DeleteMapping("/parallel/voluntario/{id}")
    public void update(@PathVariable(value = "id") String id) {
        int input_id = Integer.parseInt(id);
        this.repo.delete(input_id);
    }
}
