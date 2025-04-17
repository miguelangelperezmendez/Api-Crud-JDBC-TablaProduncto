package com.APIConJDBC.ConfiguracioBeans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class AppConfig {
    //AQUI SE DEFINEN LOS BEANS NECESARIOS PARA LA EJECUCION

    //CONFIGURAMOS EL DATASOURSE

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(); //Esta variable almacena los datos de acceso a la base de datos
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE"); //URL de la base de datos
        dataSource.setUsername("System");
        dataSource.setPassword("Astrix12");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //Nombre de la clase que maneja la base de datos

        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
