package com.stackroute.activitystream.UserService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream"})
@EntityScan(basePackages={"com.stackroute.activitystream"})
@EnableAutoConfiguration
//this statement was not there and so Field userDa error is coming.
@ComponentScan(basePackages={"com.stackroute.activitystream"})

//above base pacakge names are wrong.
public class UserServiceApplication {
/*	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory) {
	    return hibernateEntityManagerFactory.getSessionFactory();
	}*/
	
	public static void main(String[] args) {
	
		SpringApplication.run(UserServiceApplication.class, args);
	}
	

}
