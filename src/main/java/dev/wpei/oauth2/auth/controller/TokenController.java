package dev.wpei.oauth2.auth.controller;

import dev.wpei.oauth2.auth.dto.AccessTokenRequest;
import dev.wpei.oauth2.auth.dto.AccessTokenRequest2;
import dev.wpei.oauth2.auth.dto.AccessTokenResponse;
import dev.wpei.oauth2.auth.error.AccessTokenException;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
public class TokenController {

    @PostMapping("/token")
    public AccessTokenResponse accessToken(
            @RequestBody AccessTokenRequest request,
            Model model) {
        System.out.println("request.getClientId(): " + request.getClientId());
        System.out.println("request.getClientSecret(): " + request.getClientSecret());
        if(!(request.getClientId().equals("test_client") && request.getClientSecret().equals("test_clientSecret"))) {
            throw new AccessTokenException("client id/password is not valid.");
        }
        AccessTokenResponse response = new AccessTokenResponse(
                "test_accessToken",
                "access_token"
        );
        return response;
    }

    @PostMapping("/access_token")
    public AccessTokenResponse accessToken2(
            @RequestBody AccessTokenRequest2 request,
            Model model) {
        AccessTokenResponse response = new AccessTokenResponse(
                "test_accessToken",
                "access_token"
        );
        return response;
    }

}
