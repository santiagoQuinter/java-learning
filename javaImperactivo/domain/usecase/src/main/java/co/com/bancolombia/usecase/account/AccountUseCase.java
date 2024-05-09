package co.com.bancolombia.usecase.account;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.account.gateways.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

//crea el contructor de la clase con los argumentos requeridos
// Podemos usar el anotation o podemos crear el constructro por nosotros mismos
//@RequiredArgsConstructor
//@RequiredArgsConstructor
public class AccountUseCase {
    //Se agrega el final para que lo detecte como un campo obligatorio
    public final AccountRepository accountRepository;

    public AccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccount(){
        return accountRepository.getAllAccount();
    }

    public Account getAccountById(int accountNumber){
        return accountRepository.getAcountById(accountNumber);
    }
}
