package co.com.bancolombia.mongo;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.mongo.dto.AccountDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

import java.util.List;

//Aquí mapeamos el DTO
public interface MongoDBRepository extends ReactiveMongoRepository<AccountDTO/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<AccountDTO/* change for adapter model */> {

    //Se puede  agregar y pasar el querry de mongo
    //public Account findByAccountNumber(int accountNumber);
    //Todo validar el como quedaría implementada de esta forma
}
