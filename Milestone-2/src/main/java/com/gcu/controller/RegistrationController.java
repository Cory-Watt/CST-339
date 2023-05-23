package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String displayRegistrationForm(Model model) {
        model.addAttribute("UserModel", new UserModel());
        return "UserRegistration";
    }

    @PostMapping
    public String registerUser(UserModel userModel, Model model) {
        // Process the user registration logic here
        // You can access the user details from the userModel object
        // For example: userModel.getUsername(), userModel.getPassword(), userModel.getEmail()

        // Add any additional logic or database operations if required

        // Display a success message or redirect to a success page
        model.addAttribute("message", "User registration successful!");
        return "registrationSuccess";
    }
}