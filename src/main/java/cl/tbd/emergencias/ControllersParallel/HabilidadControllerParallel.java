package cl.tbd.emergencias.ControllersParallel;

import cl.tbd.emergencias.Models.Habilidad;
import cl.tbd.emergencias.RepositoriesParallel.HabilidadRepositoryParallel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabilidadControllerParallel {
    @Autowired
    private HabilidadRepositoryParallel repo;

    @CrossOrigin("*")
    @GetMapping("/parallel/habilidad")
    public List<Habilidad> getAll() {
        return this.repo.getAll();
    }

    @CrossOrigin("*")
    @GetMapping("/parallel/habilidad/{id}")
    public Habilidad getOneById(@PathVariable(value = "id") String id) {
        return this.repo.getOneById(Integer.parseInt(id));
    }

    @CrossOrigin("*")
    @PostMapping("/parallel/habilidad/{id}/{descrip}")
    public void insert(@PathVariable(value = "id") String id,
                       @PathVariable(value = "descrip") String descrip) {
        int input_id = Integer.parseInt(id);
        Habilidad habilidad = new Habilidad(input_id, descrip);
    }

    @CrossOrigin("*")
    @PutMapping("/parallel/habilidad/{id}/{descrip}")
    public void update(@PathVariable(value = "id") String id,
                       @PathVariable(value = "descrip") String descrip) {
        int input_id = Integer.parseInt(id);
        Habilidad habilidad = new Habilidad(input_id, descrip);
        this.repo.update(habilidad, input_id);
    }

    @CrossOrigin("*")
    @DeleteMapping("/parallel/habilidad/{id}")
    public void update(@PathVariable(value = "id") String id) {
        int input_id = Integer.parseInt(id);
        this.repo.delete(input_id);
    }
}
