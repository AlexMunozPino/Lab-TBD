package cl.tbd.emergencias.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.tbd.emergencias.Repositories.EmergenciaRepository;
import cl.tbd.emergencias.Repositories.VoluntarioRepository;
import cl.tbd.emergencias.Repositories.HabilidadRepository;
import cl.tbd.emergencias.Repositories.RankingRepository;
import cl.tbd.emergencias.Services.RankingService;
import cl.tbd.emergencias.Services.RankingServiceImpl;
import cl.tbd.emergencias.Services.EmergenciaService;
import cl.tbd.emergencias.Services.EmergenciaServiceImpl;
import cl.tbd.emergencias.Services.HabilidadService;
import cl.tbd.emergencias.Services.HabilidadServiceImpl;
import cl.tbd.emergencias.Services.VoluntarioService;
import cl.tbd.emergencias.Services.VoluntarioServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public VoluntarioService voluntarioInjection(){
        return new VoluntarioServiceImpl();
    }

    @Bean
    public VoluntarioRepository voluntarioRepositoryInjection(){
        return new VoluntarioRepository();
    }

    @Bean
    public RankingRepository rankingRepositoryInjection(){
        return new RankingRepository();
    }

    @Bean
    public RankingService rankingInjection(){
        return new RankingServiceImpl();
    }

    @Bean
    public HabilidadService habilidadInjection(){
        return new HabilidadServiceImpl();
    }

    @Bean
    public HabilidadRepository habilidadRepositoryInjection(){
        return new HabilidadRepository();
    }

    @Bean
    public EmergenciaService emergenciaInjection(){
        return new EmergenciaServiceImpl();
    }

    @Bean
    public EmergenciaRepository emergenciaRepositoryInjection(){
        return new EmergenciaRepository();
    }
    
}