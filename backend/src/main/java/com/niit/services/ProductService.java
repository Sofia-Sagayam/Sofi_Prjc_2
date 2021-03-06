package com.niit.services;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface ProductService {
List<Product> getAllProducts();
boolean createProduct(Product product);
Product getproduct(int id);
boolean deleteProduct(int id);
void saveOrUpdateProduct(Product product);
boolean createCategory(Category category);
List<Category> getAllCategories();

}

