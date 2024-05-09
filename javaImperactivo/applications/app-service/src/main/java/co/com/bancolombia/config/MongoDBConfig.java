package co.com.bancolombia.config;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;



@Configuration
public class MongoDBConfig {
    @Value("${mongoConfig.user}")
    private String dbUser;
    @Value("${mongoConfig.password}")
    private String dbPassword;
    @Value("${mongoConfig.database}")
    private String dbName;
    @Value("${mongoConfig.connectionString}")
    private String dbConnectionString;

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory(){
         ConnectionString connectionString = new ConnectionString(dbConnectionString);
         MongoClientSettings settings = MongoClientSettings.builder()
                 .applyConnectionString(connectionString)
                 .build();

         return new SimpleMongoClientDatabaseFactory(MongoClients.create(settings), dbName);

        //validar clases deprecadas
        /*
        MongoClientURI uri = new MongoClientURI(dbConnectionString);
        MongoClient mongoClient = new MongoClient(uri);
        return new SimpleMongoFactory(mongoClient, this.dbName);   */
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDatabaseFactory());
        return mongoTemplate;
    }


}
