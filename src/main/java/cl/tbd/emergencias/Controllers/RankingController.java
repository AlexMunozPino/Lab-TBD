package cl.tbd.emergencias.Controllers;

import cl.tbd.emergencias.Models.Ranking;
import cl.tbd.emergencias.Services.RankingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingController {

    @Autowired
    private RankingService rankingService;


    @GetMapping("/ranking")
    //Método para obtener toda la información contenida en la tabla Ranking
    public List<Ranking> getAll(){
        return this.rankingService.getAll();
    }

    @GetMapping("/ranking/{id}")
    //Método para obtener un ranking específica según su id
    public Ranking getOneById(@PathVariable(value="id") String id){
        return this.rankingService.getOneById(Integer.parseInt(id));
    }
}
