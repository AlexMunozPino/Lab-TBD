package cl.tbd.emergencias.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseContext {
    //Definir url de la BD, usuario y password
    //Ejemplo: jdbc:postgresql://127.0.0.1:5432/postgres, usuario, password
    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
    private String dbPass;

    @Value("${parallel1.url}")
    private String parallelUrl1;

    @Value("${parallel2.url}")
    private String parallelUrl2;

    @Value("${parallel3.url}")
    private String parallelUrl3;


    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dbUrl, dbUser, dbPass);
    }

    @Bean(name="parallel")
    public List<Sql2o> sql2o_parallel() {
        List<Sql2o> sql2o_parallel = new ArrayList<Sql2o>(3);
        sql2o_parallel.add(new Sql2o(parallelUrl1, dbUser, dbPass));
        sql2o_parallel.add(new Sql2o(parallelUrl2, dbUser, dbPass));
        sql2o_parallel.add(new Sql2o(parallelUrl3, dbUser, dbPass));
        return sql2o_parallel;
    }

}