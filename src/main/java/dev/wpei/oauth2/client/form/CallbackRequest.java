package dev.wpei.oauth2.client.form;

import lombok.Data;

@Data
public class CallbackRequest {
    public String grantType;
    public String code;
    public String redirectUri;
    public String clientId;
    public String clientSecret;
}
