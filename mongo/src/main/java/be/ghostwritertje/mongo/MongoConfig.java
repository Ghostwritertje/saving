package be.ghostwritertje.mongo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Jorandeboever
 * Date: 14-Oct-16.
 */
@Configuration
@ComponentScan(value = {"be.ghostwritertje.mongo.datasource"})
@EnableMongoRepositories(basePackages = {"be.ghostwritertje.mongo.dao"})
public class MongoConfig {
}
