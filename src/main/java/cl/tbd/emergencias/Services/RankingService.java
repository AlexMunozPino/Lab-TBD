package cl.tbd.emergencias.Services;

import java.util.List;

import cl.tbd.emergencias.Models.Ranking;

public interface RankingService {

    List<Ranking> getAll();

    Ranking getOneById(Integer id);
    
}