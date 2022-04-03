package dev.wpei.oauth2.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class LoginRequest {
    @NotBlank
    public String id;

    @NotBlank
    public String password;
}
