package be.ghostwritertje;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jorandeboever
 * Date: 10-Oct-16.
 */
@Configuration
@ComponentScan(basePackages = {"be.ghostwritertje.services", "be.ghostwritertje.dao"})
public class ApplicationConfig {
}
