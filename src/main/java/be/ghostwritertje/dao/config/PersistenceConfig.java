package be.ghostwritertje.dao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@EnableJpaRepositories({"be.ghostwritertje.dao.repository"})
@Configuration
public class PersistenceConfig {

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(DataSource dataSource){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(dataSource);
        return jpaTransactionManager;
    }

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties jpaProperties){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan("be.ghostwritertje.domain");

        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(jpaProperties);

        return entityManagerFactory;
    }

    @Bean
    public DataSource dataSource(
            @Value("${OPENSHIFT_POSTGRESQL_DB_HOST}") String host,
            @Value("${OPENSHIFT_POSTGRESQL_DB_PORT}") String port,
            @Value("${OPENSHIFT_POSTGRESQL_DB_USERNAME}") String username,
            @Value("${OPENSHIFT_POSTGRESQL_DB_PASSWORD}") String password,
            @Value("${OPENSHIFT_POSTGRESQL_DB_URL}") String url
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://"+host + ":"+ port + "/saving" + "?user=" + username + "&password=" + password);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println(url);
        return dataSource;
    }

    @Bean
    public Properties jpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("connection.pool_size", "1");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        properties.setProperty("hibernate.current_session_context_class", "org.hibernate.context.internal.ThreadLocalSessionContext");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        return properties;
    }
}
