package com.niit.project_backend;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.model.Category;
//import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.services.ProductService;
import com.niit.services.ProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Product product=new Product();
       product.setProductname("laptop");
       product.setQuantity(10);
       product.setPrice(50.90); 
       product.setProductDescription("aaaa");
       
     
       
      
      // category.setCategoryname("Hot sale");
       //category.setCategoryname("New Arrival");
      /* category.setCategoryname("Offer");
     product.setCategory(category);*/
     /*  category.setCategoryname("new arrival");
       */
      
       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class);
       SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
       System.out.println(sessionFactory);
       ProductService productservice=(ProductService)context.getBean("productServiceImpl");
      productservice.createProduct(product);
      // productservice.createCategory(category);
       
        
    }
}
