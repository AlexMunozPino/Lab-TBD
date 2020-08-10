package cl.tbd.emergencias.Config;

import cl.tbd.emergencias.Repositories.*;
import cl.tbd.emergencias.Services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public TareaService tareaInjection(){
        return new TareaServiceImpl();
    }

    @Bean
    public TareaRepository tareaRepositoryInjection(){
        return new TareaRepository();
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

    @Bean
    public LogTareaService logTareaInjection() { return new LogTareaServiceImpl(); }
    @Bean
    public LogTareaRepository logTareaRepositoryInjection() { return new LogTareaRepository(); }
}