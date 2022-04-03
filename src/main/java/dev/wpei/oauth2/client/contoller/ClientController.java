package dev.wpei.oauth2.client.contoller;

import dev.wpei.oauth2.client.form.CallbackRequest;
import dev.wpei.oauth2.client.form.HelloForm;
import dev.wpei.oauth2.auth.dto.AccessTokenResponse;
import dev.wpei.oauth2.client.service.GetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClientController {

    @Autowired
    GetTokenService tokenService;

    @GetMapping("/hello")
    public String get(Model model) {
        HelloForm response = new HelloForm();
        model.addAttribute(response);
        return "/client/hello";
    }

    @PostMapping("/get_auth")
    public String get_auth(
            @Validated HelloForm request,
            BindingResult result,
            RedirectAttributes forward) {
        if (result.hasErrors()) {
            result.getFieldErrors().stream().forEach(e -> e.getDefaultMessage());
            return "/error";
        }
        forward.addFlashAttribute(request);
        return "redirect:/auth_check";
    }

    @GetMapping("/callback")
    public String callback(
            @Validated CallbackRequest request,
            BindingResult result,
            Model model) {
        // Null here
        System.out.println("Id in callback: " + request.getClientId());
        System.out.println("Secret in callback: " + request.getClientSecret());
        AccessTokenResponse accessTokenResponse = tokenService.getToken(request.getClientId(), request.getClientSecret(), request.getCode(), request.getGrantType());
        model.addAttribute(accessTokenResponse);
        return "/client/list";
    }

    @GetMapping("/show_access_token")
    public String list(
            @Validated HelloForm request,
            BindingResult result,
            @RequestParam String code,
            @RequestParam String grantType,
            Model model) {
        // Null here
        AccessTokenResponse accessTokenResponse = tokenService.getToken(request.getClientId(), code, grantType);
        model.addAttribute(accessTokenResponse);
        return "/client/list";
    }

}