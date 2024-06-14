package co.com.bancolombia.usecase.registeraccount;

import co.com.bancolombia.model.account.Account;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RequiredArgsConstructor
public class RegisterAccountUseCase {

    public Mono<Account> register(String name, String statusId){
        /*
        * regla de negocio, primero llamar a getStatus
        * Al intentar solucionarlo se puede caer en problemas  de concurrencia
        * o de condiciones de carrera -- todos lo hilos accediendo al mismo valor
        *
        * Por eso se genero la regla: Para asignar valores las variables deben ser finales
        * otra es devolver la variables de todas las funciones pero estariamos modificando el dominio
        *
        * También podemos generar un contexto y pasarlo por todo
        *
        * usamos la ley de la asociatividad dentro del primer flatmap agregar el otro
        *
        * */

        /*
        return getStatus(name)
                .flatMap(status -> Mono.zip(legalValidation(name), disponibilityValidation())
                .map(legal -> Account.newAccout(0, name, status)))
                .flatMap(this::finalValidation)
                .flatMap(this::saveAccount);

        *


        //Zip se encarga de hacer la ejecución en paralelo de los 2
        //Mono.zip(legalValidation(name), disponibilityValidation());

        //Validación legal (Se realiza un llamado a un servicio externo)
        return  Mono.zip(legalValidation(name), disponibilityValidation())
                //legalValidation(name)
                //obtener una disponibilidad
                //.flatMap(legal ->  disponibilityValidation())
                //llamado a un servicio para retornar el estatus de la cuenta
                .flatMap(disponibility -> getStatus(name))
                //generamos nuestra cuenta
                //.flatMap(status -> generateAccount(name, status))
                //usamos map para concatenar temas no asincronos
                .map(status -> Account.newAccout(0, name, status))
                //realiza validaciones finales
                .flatMap(this::finalValidation)
                //Persistimos la cuenta
                .flatMap(this::saveAccount);

        //reto: poner a correr de forma paralela legalValidation y disponibiliy validation
        //con el objetivo de reducir el tiempo a el tiempo de delay más largo y que no se sumen

    }

    private Mono<Account> generateAccount(String name, String status){
        return Mono.just(Account.newAccout(0, name, status));
    }

    //se realiza un llamado a un servicio externo
    private Mono<String> legalValidation(String accountName){
        return Mono.just(accountName).delayElement(Duration.ofSeconds(2));
    }

    //Con el fin de validar si el posible realizar el registro de la cuenta
    private Mono<Integer> disponibilityValidation(){
        return Mono.just(9).delayElement(Duration.ofSeconds(2));
    }

    //llamar servicios para validar el status de al cuenta
    private Mono<String> getStatus(String accountName){
        return Mono.just("OK");
    }

    //realizar validaciones finales
    private Mono<Account> finalValidation(Account account){
        return Mono.just(account);
    }

    //Persistencia de la cuenta
    private Mono<Account> saveAccount(Account account){
        return Mono.just(account);
    }

}
