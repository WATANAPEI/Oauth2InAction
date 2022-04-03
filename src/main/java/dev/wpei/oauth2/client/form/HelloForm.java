package dev.wpei.oauth2.client.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class HelloForm {
    @NotBlank(message = "requestType must be specified.")
    public String requestType;
    @NotBlank
    public String scope;
    @NotBlank
    public String clientId;
    @NotBlank
    public String redirectUri;
    @NotBlank
    public String state;

    public HelloForm() {
        requestType = "AuthCode";
        scope = "read_user";
        clientId = "test_client";
        redirectUri = "http://localhost:8080/callback";
        state = "random_value";
    }
}
