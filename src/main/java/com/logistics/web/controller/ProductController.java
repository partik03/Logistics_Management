package com.logistics.web.controller;

import com.logistics.web.models.Product;
import com.logistics.web.services.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    public ProductServiceImpl productService;

    @Autowired
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
    @ResponseBody
    public int addProduct(@Valid @NotNull @RequestBody Product product){
        return productService.handleAddProduct(product);
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
