package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
@Autowired
private SessionFactory sessionFactory;
public ProductDaoImpl() {
	System.out.println("Product Dao Instantiated");
}
	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		//HQL - Hibernate query Language
		Query query=session.createQuery("from Product");//Select * from Product
		return query.list(); //List of Product objects
	}
	public boolean createProduct(Product product) {
		try {
		System.out.println(product.getPrice());
		Session session=sessionFactory.getCurrentSession();
		session.save(product);
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public Product getproduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class,id);
		return product;
		
	}
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		try {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class,id);
		session.delete(product);
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
		public void saveOrUpdateProduct(Product product) {
			Session session=sessionFactory.getCurrentSession();
			System.out.println("BEFORE INSERT/UPDATE " + product.getId());
			//if id==0, insert query
			//if id exits in the table, update query
			session.saveOrUpdate(product);//INsert into product values (?,.....)
			System.out.println("AFTER INSERT/UPDATE " + product.getId());
			
		}
		public boolean createCategory(Category category) {
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			return true;
		}
		public List<Category> getAllCategories() {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Category");
			return query.list();
		}
	}



