package br.com.bev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BevApplication {
	public static void main(String[] args) {
		SpringApplication.run(BevApplication.class, args);
	}
}
