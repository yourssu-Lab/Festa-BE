package org.yourssu.festa;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@OpenAPIDefinition(
		servers = {
				@Server(url = "https://api.festa.yourssu.com", description = "Production Server"),
				@Server(url = "http://localhost:9005", description = "Local Development Server")
		}
)
public class FestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FestaApplication.class, args);
	}

}
