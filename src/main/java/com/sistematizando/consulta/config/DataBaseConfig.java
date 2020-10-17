package com.sistematizando.consulta.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@Configuration
public class DataBaseConfig {

    @Bean(name = "datasourceDB")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSourceOne() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "datasourcePrimary")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplateOne(@Qualifier("datasourceDB") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }
}