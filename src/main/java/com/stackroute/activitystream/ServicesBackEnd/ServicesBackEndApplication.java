package com.stackroute.activitystream.ServicesBackEnd;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream.ServicesBackEnd"})
@EntityScan(basePackages={"com.stackroute.activitystream.ServicesBackEnd"})
public class ServicesBackEndApplication {
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory) {
	    return hibernateEntityManagerFactory.getSessionFactory();
	}
	
	@RequestMapping("/")
    String hello() {
        return "hello world";
    }
	public static void main(String[] args) {
		SpringApplication.run(ServicesBackEndApplication.class, args);
	}
}
