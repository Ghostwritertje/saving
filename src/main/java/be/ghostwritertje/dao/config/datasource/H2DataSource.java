package be.ghostwritertje.dao.config.datasource;

import org.hibernate.dialect.H2Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Profile("local")
@Configuration
public class H2DataSource {

    @Bean
    public DataSource localDataSource(

    ) {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .setName("h2")
                .build();
        return db;
    }

    @Bean
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("connection.pool_size", "1");
        properties.setProperty("hibernate.dialect", H2Dialect.class.getName());
        properties.setProperty("hibernate.connection.url", "jdbc:h2:~/test");
        properties.setProperty("hibernate.current_session_context_class", "org.hibernate.context.internal.ThreadLocalSessionContext");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        return properties;
    }
}
