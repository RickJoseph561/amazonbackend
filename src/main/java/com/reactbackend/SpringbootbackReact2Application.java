package com.reactbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringbootbackReact2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbackReact2Application.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedMethods("GET", "OPTIONS", "PUT", "POST", "DELETE", "PATCH")
					.allowedOrigins("http://localhost:3000")
					.allowedHeaders("*")
					.allowCredentials(true);
			}
		};
	}
}
