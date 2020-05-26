package cl.tbd.emergencias.Services;

import java.util.List;

import cl.tbd.emergencias.Models.Ranking;
import cl.tbd.emergencias.Repositories.RankingRepository;

public class RankingServiceImpl implements RankingService {

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