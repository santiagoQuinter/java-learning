package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.RegisterAccountRequestDto;
import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.exceptions.BusinessException;
import co.com.bancolombia.model.exceptions.message.BusinessErrorMessage;
import co.com.bancolombia.usecase.registeraccount.RegisterAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final RegisterAccountUseCase registerAccountUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(RegisterAccountRequestDto.class)
                //Encadenamos o componemos las demás funciones
                .switchIfEmpty(Mono.error(new BusinessException(BusinessErrorMessage.INVALID_REQUEST)))
                .flatMap(request -> registerAccountUseCase.register(request.getName(), request.getStatusId()))
                .flatMap(account -> ServerResponse.ok().bodyValue(account));


        //return ServerResponse.ok().body(register, Account.class);
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
