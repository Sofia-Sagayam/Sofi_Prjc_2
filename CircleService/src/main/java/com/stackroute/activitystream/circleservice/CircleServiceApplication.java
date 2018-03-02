package com.stackroute.activitystream.circleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream"})
@EntityScan(basePackages={"com.stackroute.activitystream"})

@ComponentScan(basePackages={"com.stackroute.activitystream"})

public class CircleServiceApplication {

	/*@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory) {
	    return hibernateEntityManagerFactory.getSessionFactory();
	}
	*/
	@GetMapping("/")
    String hello() {
        return "hello world";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CircleServiceApplication.class, args);
	}
}
