package be.ghostwritertje.services;

import be.ghostwritertje.repository.configuration.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Jorandeboever
 * Date: 14-Oct-16.
 */
@Configuration
@ComponentScan(basePackages = {"be.ghostwritertje.services"})
@Import(PersistenceConfig.class)
public class ServiceConfig {
}
