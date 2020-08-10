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
    public List<Ranking> getAll(){
        return this.rankingService.getAll();
    }

    @GetMapping("/ranking/{id}")
    public Ranking getOneById(@PathVariable(value="id") String id){
        return this.rankingService.getOneById(Integer.parseInt(id));
    }
}
