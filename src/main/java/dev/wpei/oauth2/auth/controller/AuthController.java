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
        model.addAttribute(request);
        return "/auth/auth_check";
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
        System.out.println("clientId: " + request.getClientId());
        model.addFlashAttribute(request);
        String code = String.valueOf(Math.random());
        String grantType = "authorization_code";
        return "redirect:/show_access_token?client_id=" + request.getClientId() + "&code=" + code + "&grant_type=" + grantType;
    }


}
