package cl.tbd.emergencias.ControllersParallel;

import cl.tbd.emergencias.Models.Vol_habilidad;
import cl.tbd.emergencias.RepositoriesParallel.VoluntarioHabilidadRepositoryParallel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntarioHabilidadControllerParallel {

    @Autowired
    private VoluntarioHabilidadRepositoryParallel repo;

    @CrossOrigin("*")
    @GetMapping("/parallel/vol-habilidad")
    public List<Vol_habilidad> getAll() {
        return this.repo.getAll();
    }

    @CrossOrigin("*")
    @GetMapping("/parallel/vol-habilidad/{id}")
    public Vol_habilidad getOneById(@PathVariable(value = "id") String id) {
        return this.repo.getOneById(Integer.parseInt(id));
    }

    @CrossOrigin("*")
    @PostMapping("/parallel/vol-habilidad/{id}/{id_habilidad}/{id_voluntario}")
    public void insert(@PathVariable(value = "id") String id,
                       @PathVariable(value = "id_habilidad") String id_habilidad,
                       @PathVariable(value = "id_voluntario") String id_voluntario) {
        int input_id = Integer.parseInt(id);
        int input_id_hab = Integer.parseInt(id_habilidad);
        int input_id_vol = Integer.parseInt(id_voluntario);
        Vol_habilidad vol_habilidad = new Vol_habilidad(input_id, input_id_vol, input_id_hab);
        this.repo.insert(vol_habilidad);
    }

    @CrossOrigin("*")
    @PutMapping("/parallel/vol-habilidad/{id}/{id_habilidad}/{id_voluntario}")
    public void update(@PathVariable(value = "id") String id,
                       @PathVariable(value = "id_habilidad") String id_habilidad,
                       @PathVariable(value = "id_voluntario") String id_voluntario) {
        int input_id = Integer.parseInt(id);
        int input_id_hab = Integer.parseInt(id_habilidad);
        int input_id_vol = Integer.parseInt(id_voluntario);
        Vol_habilidad vol_habilidad = new Vol_habilidad(input_id, input_id_vol, input_id_hab);
        this.repo.update(vol_habilidad, input_id);
    }

    @CrossOrigin("*")
    @DeleteMapping("/parallel/vol-habilidad/{id}")
    public void update(@PathVariable(value = "id") String id) {
        int input_id = Integer.parseInt(id);
        this.repo.delete(input_id);
    }
}
