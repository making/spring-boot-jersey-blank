package xxxxxx.yyyyyy.zzzzzz;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Configuration
    public static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("xxxxxx.yyyyyy.zzzzzz");
        }
    }

    @Bean
    DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .build();
        return new DataSourceSpy(dataSource);
    }
}