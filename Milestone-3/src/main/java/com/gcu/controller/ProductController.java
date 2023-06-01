package com.gcu.controller;

import javax.validation.Valid;
import com.gcu.model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/create")
    public String displayProductForm(Model model) {
    	model.addAttribute("productModel", new ProductModel());
        return "productForm";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productModel") ProductModel product,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "productForm";
        }

        // Process the product creation logic 
        // access the product details from the product object
        // example: product.getName(), product.getDescription(), product.getPrice()

        model.addAttribute("message", "Product creation successful!");
        return "productSuccess";
    }
}