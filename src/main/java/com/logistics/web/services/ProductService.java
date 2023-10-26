package com.logistics.web.services;

import com.logistics.web.models.Product;

import java.util.List;

public interface ProductService {

    public int handleAddProduct(Product product);

    public Product handleGetProductById(int id);

    public List<Product> handleGetAllProducts();
    public List<Product> handleGetAllProductsByUserId(int id);

    public int handleDeleteProductById(int id);

    public int handleUpdateProductById(int id, Product product);
}
