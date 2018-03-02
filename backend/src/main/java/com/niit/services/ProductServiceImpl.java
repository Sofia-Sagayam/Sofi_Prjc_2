package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
private ProductDao productDao;
	public ProductServiceImpl() {
		System.out.println("ProductService instantiated");
	}
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	public boolean createProduct(Product obj) {
		// TODO Auto-generated method stub
		System.out.println(obj.getPrice());
		 return productDao.createProduct(obj);
	}
	public Product getproduct(int id) {
		// TODO Auto-generated method stub
		return productDao.getproduct( id);
	}
	public boolean deleteProduct(int id) {
         return productDao.deleteProduct(id);	
	}
	public void saveOrUpdateProduct(Product product) {
		productDao.saveOrUpdateProduct(product);
		
	}
	public boolean createCategory(Category category) {
		// TODO Auto-generated method stub
		 return productDao.createCategory(category);
	}
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return productDao.getAllCategories();
	}

}
