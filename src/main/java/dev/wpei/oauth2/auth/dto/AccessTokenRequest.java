package dev.wpei.oauth2.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessTokenRequest {
    private String clientId;
    private String clientSecret;
}
