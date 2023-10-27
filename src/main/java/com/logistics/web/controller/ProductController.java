package com.logistics.web.controller;

import com.logistics.web.models.Product;
import com.logistics.web.services.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        // return "redirect:/product";
        return "redirect:/admin/dashboard/products";
    }

    @DeleteMapping("/product/{id}")
    @ResponseBody
    public int deleteProductById(@Valid @NotNull @PathVariable("id") int id){
        return productService.handleDeleteProductById(id);
    }

    @PutMapping("/product/{id}")
    @ResponseBody
    public int updateProductById(@Valid @NotNull @PathVariable("id") int id, @Valid @NotNull @RequestBody Product product){
        return productService.handleUpdateProductById(id,product);
    }
}
