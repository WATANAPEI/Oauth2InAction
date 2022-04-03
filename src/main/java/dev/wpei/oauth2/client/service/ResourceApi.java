package dev.wpei.oauth2.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="resource", url="localhost:8080")
public interface ResourceApi {
    @GetMapping(value="/sakes")
    public List<String> getSakeList(String accessToken);
}
