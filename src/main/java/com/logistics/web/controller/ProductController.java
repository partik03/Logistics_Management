package com.logistics.web.controller;

import com.logistics.web.models.Product;
import com.logistics.web.services.impl.AuthenticationServiceImpl;
import com.logistics.web.services.impl.ProductServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import java.util.List;

@Controller
public class ProductController {
    @Autowired
    public ProductServiceImpl productService;

    
    public ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }

    @Autowired
    public AuthenticationServiceImpl authenticationService;



    @GetMapping("/product")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.handleGetAllProducts();
    }
    @GetMapping("/productuser/{id}")
    @ResponseBody
    public List<Product> getAllProductsByUserId(@Valid @NotNull @PathVariable("id") int id){
        return productService.handleGetAllProductsByUserId(id);
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    public Product getProductById(@Valid @NotNull @PathVariable("id") int id){
        return productService.handleGetProductById(id);
    }

    @PostMapping("/product")
    public String addProduct(@ModelAttribute Product product, Model model){
        productService.handleAddProduct(product);
        return "redirect:/admin/dashboard/products";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProductById(@Valid @NotNull @PathVariable("id") int id, RedirectAttributes redirectAttributes){
        productService.handleDeleteProductById(id);
        return "redirect:/admin/dashboard/products";
    }

    @PutMapping("/product/{id}")
    public String updateProductById(@Valid @NotNull @PathVariable("id") int id, @ModelAttribute Product product,Model model){
        productService.handleUpdateProductById(id,product);
        return "redirect:/admin/dashboard/products";
    }
    @PostMapping("user/product")
    public String userAddProduct(@ModelAttribute Product product, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        int userId = authenticationService.handleGetUserIdByUsername(name);
        product.setUserId(userId);
        productService.handleAddProduct(product);
        return "redirect:/user/products";
    }

    @DeleteMapping("user/product/{id}")
    public String userDeleteProductById(@Valid @NotNull @PathVariable("id") int id){
        Product product = getProductById(id);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        int userId = authenticationService.handleGetUserIdByUsername(name);

        if(userId != product.getUserId()){
            return "redirect:/user/products";
        }

        productService.handleDeleteProductById(id);
        return "redirect:/user/products";
    }

    @PutMapping("user/product/{id}")
    public String userUpdateProductById(@Valid @NotNull @PathVariable("id") int id, @ModelAttribute Product product,Model model){
        Product product1 = getProductById(id);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        int userId = authenticationService.handleGetUserIdByUsername(name);

        if(userId != product1.getUserId()){
            return "redirect:/user/products";
        }
        product.setUserId(userId);
        productService.handleUpdateProductById(id,product);
        return "redirect:/user/products";
    }
}
