package co.com.bancolombia.model.exceptions.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TechnicalErrorMessage {
    TECNICAL_RESTCLIENT_ERROR("SCT0010", "Technical error rest client"),
    EXTERNAL_MESSAGE_ERROR("SFT9999", "Error");

    private final String code;
    private final String message;
}
