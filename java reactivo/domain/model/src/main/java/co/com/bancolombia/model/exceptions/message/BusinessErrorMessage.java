package co.com.bancolombia.model.exceptions.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorMessage {
    INVALID_REQUEST("SFB0000", "Invalid request"),
    ACCOUNT_VALIDATION_ERROR("SFB0001", "Account valid error"),
    ACCOUNT_FIND_ERROR("SFB0002", "Account find error"),
    CHANNEL_TRASACTION_NOT_FOUND("SFB0003", "Channel trasaction not found");

    private final String code;
    private final String message;
}
