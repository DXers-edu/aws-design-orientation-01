package com.dxers.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxers.web.dto.request.auth.SignUpRequestDto;
import com.dxers.web.dto.response.ResponseCode;
import com.dxers.web.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    
    @GetMapping("sign-in")
    public String signIn() {
        
        return "auth/sign-in";
    }
    
    @GetMapping("sign-up")
    public String signUp(Model model) {
        if (!model.containsAttribute("signUpForm")) model.addAttribute("signUpForm", new SignUpRequestDto());
        return "auth/sign-up";
    }

    @PostMapping("sign-up")
    public String signUpProcess(
        @Valid @ModelAttribute("signUpForm") SignUpRequestDto requestBody,
        BindingResult bindingResult,
        HttpServletRequest request,
        Model model
    ) {
        if (bindingResult.hasErrors()) return "auth/sign-up";

        String result = authService.signUp(requestBody);

        String path = result.equals(ResponseCode.SUCCESS) ? "auth/sign-in" : "auth/sign-up";
        if (!result.equals(ResponseCode.SUCCESS)) model.addAttribute("errorMessage", result);

        return path;
    }

}
