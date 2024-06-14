package co.com.bancolombia.model.exceptions;

import lombok.Getter;

@Getter
public class TechnicalException extends RuntimeException {
    private final TechnicalException errorMessage;

    public TechnicalException(TechnicalException errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
