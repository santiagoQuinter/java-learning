package co.com.bancolombia.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDBRepository extends MongoRepository<Object/* change for adapter model */, String> , QueryByExampleExecutor<Object/* change for adapter model */> {
}
