package com.stackroute.activitystream.ServicesBackEnd;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream.ServicesBackEnd"})
@EntityScan(basePackages={"com.stackroute.activitystream.ServicesBackEnd"})
@ComponentScan(basePackages={"com.stackroute.activitystream"})
@EnableAutoConfiguration
public class ServicesBackEndApplication {
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory) {
	    return hibernateEntityManagerFactory.getSessionFactory();
	}
	
	
	public static void main(String[] args) {
		
		SpringApplication springApplication = new SpringApplication();
        ApplicationContext applicationContext = SpringApplication.run(ServicesBackEndApplication.class, args);
		
		
	}
}
