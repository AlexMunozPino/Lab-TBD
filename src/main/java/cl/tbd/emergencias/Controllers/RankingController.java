package cl.tbd.emergencias.Controllers;

import cl.tbd.emergencias.Models.Ranking;
import cl.tbd.emergencias.Repositories.RankingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Sql2o;

import java.util.List;

@RestController
public class RankingController {

    private final RankingRepository rankingRepository;
    RankingController(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }

    @GetMapping("/ranking")
    public List<Ranking> getAll(){
        return this.rankingRepository.getAll();
    }

    @GetMapping("/ranking/{id}")
    public Ranking getOneById(@PathVariable(value="id") String id)
    {
        return this.rankingRepository.getOneById(Integer.parseInt(id));
    }
}
