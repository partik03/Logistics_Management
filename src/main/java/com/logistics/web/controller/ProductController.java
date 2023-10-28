package com.logistics.web.controller;

import com.logistics.web.models.Product;
import com.logistics.web.services.impl.ProductServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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
        int a= productService.handleAddProduct(product);
        System.out.println(product);
        return "redirect:/admin/dashboard/products";
    }

    @DeleteMapping("/product/{id}")
    @ResponseBody
    public String deleteProductById(@Valid @NotNull @PathVariable("id") int id, RedirectAttributes redirectAttributes){
        int res = productService.handleDeleteProductById(id);
        // if (res > 0) {
        //     // Product deleted successfully
        //     redirectAttributes.addFlashAttribute("successMessage", "Product deleted successfully.");
        // } else {
        //     // Product not found or deletion failed
        //     redirectAttributes.addFlashAttribute("errorMessage", "Product not found or deletion failed.");
        // }
        
        return "redirect:/admin/dashboard/products";
    }

    @PutMapping("/product/{id}")
    public String updateProductById(@Valid @NotNull @PathVariable("id") int id, @ModelAttribute Product product,Model model){
        // System.out.println("here hersersareas");
        productService.handleUpdateProductById(id,product);
        return "redirect:/admin/dashboard/products";
    }
}
