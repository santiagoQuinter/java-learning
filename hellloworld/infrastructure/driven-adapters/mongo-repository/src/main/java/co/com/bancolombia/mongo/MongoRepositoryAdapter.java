package co.com.bancolombia.mongo;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.account.gateways.AccountRepository;
import co.com.bancolombia.mongo.dto.AccountDTO;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//Todo ¿Qué es un adaptador?
@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Account/* change for domain model */, AccountDTO/* change for adapter model */, String, MongoDBRepository> implements AccountRepository
// implements ModelRepository from domain
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */

        //Todo ¿Por qué se usa el .clas ?
        super(repository, mapper, d -> mapper.map(d, Account.AccountBuilder.class/* change for domain model */).build());
    }

    @Override
    public List<Account> getAllAccount() {
        return (List<Account>) super.findAll();
    }

    @Override
    public Account getAcountById(int accountNumber) {
       return Account.builder().accountNumber(1).accountType(1).build();
       //Es de la misma forma que hacerlo por constructor con todos los parametros
    }
    /*Este mongo repository adapter me va a generar el build por la notación repository
    * Nos hace falta inyectar el repositorio adapter dentro de nuestro proyecto aplicación
    * Para que cuando genere el artefacto  lo genere con el reposiryAdapter*/
}
