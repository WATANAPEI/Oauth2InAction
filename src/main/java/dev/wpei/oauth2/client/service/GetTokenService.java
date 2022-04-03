package dev.wpei.oauth2.client.service;

import dev.wpei.oauth2.auth.dto.AccessTokenRequest;
import dev.wpei.oauth2.auth.dto.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@EnableFeignClients
@Scope("prototype")
@Service
public class GetTokenService {
    @Autowired
    private TokenApi tokenApi;

    public AccessTokenResponse getToken(String clientId, String clientSecret, String code, String authorizationCode) {
        AccessTokenResponse response = null;
        if(authorizationCode.equals("authorization_code")) {
            System.out.println("clientId in getToken: " + clientId);
            System.out.println("clientSecret in getToken: " + clientSecret);
            // something went wrong to pass clientId and clientSecret
            // and clientId and secret become null in getToken
            response = tokenApi.getToken(new AccessTokenRequest(clientId, clientSecret));
        }
        return response;
    }

    public AccessTokenResponse getToken(String clientId, String code, String authorizationCode) {
        AccessTokenResponse response = null;
        if(authorizationCode.equals("authorization_code")) {
            System.out.println("clientId in getToken: " + clientId);
            // something went wrong to pass clientId and clientSecret
            // and clientId and secret become null in getToken
            response = tokenApi.getToken(new AccessTokenRequest(clientId, code));
        }
        return response;
    }

}
