package com.logistics.web.services.impl;

import com.logistics.web.dao.ProductDao;
import com.logistics.web.models.Product;
import com.logistics.web.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    public ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao){
        this.productDao = productDao;
    }

    public int handleAddProduct(Product product){
        return productDao.addProduct(product);
    }

    public Product handleGetProductById(int id){
        return productDao.getProductById(id);
    }

    public List<Product> handleGetAllProducts(){
        return productDao.getAllProducts();
    }

    public int handleDeleteProductById(int id){
        return productDao.deleteProductById(id);
    }

    public int handleUpdateProductById(int id,Product product){
        return productDao.updateProductById(product,id);
    }

}
