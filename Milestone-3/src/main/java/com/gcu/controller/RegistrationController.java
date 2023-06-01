package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.model.UserModel;
import com.gcu.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String displayRegistrationForm(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "UserRegistration";
    }

    @PostMapping
    public String registerUser(UserModel userModel, Model model) {
        // Process the user registration logic using the registrationService
        registrationService.registerUser(userModel);

        // Add additional logic or database operations 

        // Display a success message or redirect to a success page
        model.addAttribute("message", "User registration successful!");
        return "registrationSuccess";
    }
}