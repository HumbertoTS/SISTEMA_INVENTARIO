package com.sistemas.app.controller;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import lombok.RequiredArgsConstructor;

>>>>>>> f369ea648191a54e26d230dc64584fc589671334
=======
import lombok.RequiredArgsConstructor;

>>>>>>> f369ea648191a54e26d230dc64584fc589671334
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
<<<<<<< HEAD
<<<<<<< HEAD
=======
@RequiredArgsConstructor
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
=======
@RequiredArgsConstructor
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
public class HomeController {

    @GetMapping("/inicio")
    public String inicio(Authentication authentication, Model model) {

        model.addAttribute("usuario",authentication.getName());

        return "inicio";
    }
}