package cl.tbd.emergencias.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.tbd.emergencias.Models.Ranking;
import cl.tbd.emergencias.Repositories.RankingRepository;

public class RankingServiceImpl implements RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    @Override
    public List<Ranking> getAll() {
        return rankingRepository.getAll();
    }


    @Override
    public Ranking getOneById(Integer id){
        return rankingRepository.getOneById(id);
    }
    
}