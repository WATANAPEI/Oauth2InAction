package dev.wpei.oauth2.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessTokenRequest2 {
    private String clientId;
    private String scope;
}
