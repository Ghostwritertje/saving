package be.ghostwritertje.mongo.datasource;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by Jorandeboever
 * Date: 14-Oct-16.
 */
@Configuration
public class MongoDataSource extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "stock";
    }

    @Bean
    public Mongo mongo() throws Exception {

        return new MongoClient();
    }
}
