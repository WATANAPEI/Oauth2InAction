package dev.wpei.oauth2.auth.controller;

import dev.wpei.oauth2.auth.dto.LoginRequest;
import dev.wpei.oauth2.client.form.CallbackRequest;
import dev.wpei.oauth2.client.form.HelloForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @GetMapping("/auth_check")
    public String authorize(
            @Validated HelloForm request,
            BindingResult result,
            Model model) {
        System.out.println("Response type: " + request.getRequestType());
        System.out.println("scope: " + request.getScope());
        System.out.println("Client id: " + request.getClientId());
        System.out.println("Redirect uri: " + request.getRedirectUri());
        System.out.println("State: " + request.getState());
        String clientSecret = "test_clientSecret";
        LoginRequest loginRequest = new LoginRequest(request.getClientId(), clientSecret);
        model.addAttribute(loginRequest);
        if(result.hasErrors()) {
            return "/error";
        }
        return "/auth/authorize";
    }

    @PostMapping("/auth")
    public String login(
            @Validated LoginRequest request,
            BindingResult result,
            RedirectAttributes model) {
        CallbackRequest callbackRequest = new CallbackRequest();
        callbackRequest.setClientId(request.getId());
        callbackRequest.setClientSecret(request.getPassword());
        callbackRequest.setCode("testCode");
        callbackRequest.setGrantType("authorization_code");
        callbackRequest.setRedirectUri("test_redirect_uri");
        model.addFlashAttribute(callbackRequest);
        System.out.println("Id: " + request.getId());
        System.out.println("Password: " + request.getPassword());
        return "redirect:/callback";
    }

    @PostMapping("/exec_auth")
    public String login(
            @Validated HelloForm request,
            BindingResult result,
            RedirectAttributes model) {
        model.addFlashAttribute(request);
        String code = String.valueOf(Math.random());
        String grantType = "authorization_code";
        return "redirect:/show_access_token?code=" + code + "&grant_type=" + grantType;
    }


}
