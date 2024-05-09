package co.com.bancolombia.config;

import co.com.bancolombia.model.account.gateways.AccountRepository;
import co.com.bancolombia.usecase.account.AccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {
    //Inyectamos el bean
    //Puede tener cualquier nombre pero va a retornar un account useCase
    @Bean
    public AccountUseCase accountUseCase(AccountRepository accountRepository){
        /*Necesitamos pasarle la dependencia que tiene el AcountUseCase que es accountRepository
        * El cual se genera automaticamente desde el driven adapter */
        return new AccountUseCase(accountRepository);
    }
}


/*La idea es que quede toda la capa configuración a nivel de aplicaicón y no desde los driven adapter o lo entry point
* ¨Para que quede más limpia la parte interna
*  por  esa razón no se hace con un autoWild o con un @component* en la capa de casos de uso*/