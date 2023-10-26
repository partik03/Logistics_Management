package com.logistics.web.services.impl;

import com.logistics.web.dao.ProductDao;
import com.logistics.web.models.Product;
import com.logistics.web.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public int handleAddProduct(Product product){
        return productDao.addProduct(product);
    }

    @Override
    public Product handleGetProductById(int id){
        return productDao.getProductById(id);
    }

    @Override
    public List<Product> handleGetAllProducts(){
        return productDao.getAllProducts();
    }

    @Override
    public List<Product> handleGetAllProductsByUserId(int id) {
        return productDao.getAllProductsByUserId(id);
    }

    @Override
    public int handleDeleteProductById(int id){
        return productDao.deleteProductById(id);
    }

    @Override
    public int handleUpdateProductById(int id,Product product){
        return productDao.updateProductById(product,id);
    }

}
