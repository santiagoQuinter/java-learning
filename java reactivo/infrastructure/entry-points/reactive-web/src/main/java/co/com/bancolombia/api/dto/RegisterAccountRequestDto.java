package co.com.bancolombia.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterAccountRequestDto {
    private String name;
    private String statusId;
}
