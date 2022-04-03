package dev.wpei.oauth2.client.service;

import dev.wpei.oauth2.auth.dto.AccessTokenRequest;
import dev.wpei.oauth2.auth.dto.AccessTokenRequest2;
import dev.wpei.oauth2.auth.dto.AccessTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="token", url="localhost:8080")
public interface TokenApi {

    @RequestMapping(value="/token", method = RequestMethod.POST)
    AccessTokenResponse getToken(@RequestBody AccessTokenRequest request);

    @PostMapping(value="/access_token")
    AccessTokenResponse getToken2(@RequestBody AccessTokenRequest2 request);
}
