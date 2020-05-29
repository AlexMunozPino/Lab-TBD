package cl.tbd.emergencias.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.tbd.emergencias.Repositories.VoluntarioRepository;
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
    
}