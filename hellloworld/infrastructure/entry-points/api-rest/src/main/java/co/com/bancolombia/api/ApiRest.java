package co.com.bancolombia.api;
import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.usecase.account.AccountUseCase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
public class ApiRest {
//    private final MyUseCase useCase;

    private final AccountUseCase accountUseCase;

    public ApiRest(AccountUseCase accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    //Debe retornar la respuesta del llamado a un método del use case,
    //Debe retornar un 200 para decir que el servicio está correcto -- actuator
    //Le agrego la dependencia de actuator y el me mapea automaticamente el health
    //TODO averiguar el funcionamiento del actuator
    @GetMapping(path = "/health")
    public String health(){
        return "up";
    }

    //Todo averiguar como funciona este @ExceptionHandler({AccessDeniedException.class})
    //Todo Empaquetar dentro de un responseEntity ??? como funciona en las apiRest

    @GetMapping(path = "/accounts")
    public ResponseEntity<List<Account>> listAccount() {
        try {
            return new ResponseEntity<List<Account>>(accountUseCase.getAllAccount(), new HttpHeaders(), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("--------------------------------error-----------------------"+ e);
            return new ResponseEntity<List<Account>>(accountUseCase.getAllAccount(), new HttpHeaders(), HttpStatus.OK);
        }


    }

    @GetMapping(path = "/account/{id}")
    public ResponseEntity<Account> getAccountById(@RequestParam int accountNumber){
        return new ResponseEntity<Account>(accountUseCase.getAccountById(accountNumber), new HttpHeaders(), HttpStatus.OK);
    }

}
