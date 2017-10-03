package com.statckroute.activitystream.ServicesBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream.ServicesBackEnd"})
@EntityScan(basePackages={"com.stackroute.activitystream.ServicesBackEnd"})
@EnableAutoConfiguration
public class ServicesBackEndApplication {
	public static void main(String[] args) {
		
		SpringApplication springApplication = new SpringApplication();
        ApplicationContext applicationContext = SpringApplication.run(ServicesBackEndApplication.class, args);
		
		
	}
}
