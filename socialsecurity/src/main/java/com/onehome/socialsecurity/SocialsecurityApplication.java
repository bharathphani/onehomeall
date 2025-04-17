package com.onehome.socialsecurity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
		info = @Info(
				title = "Social Security",
				description = "Social security for OneHome user",
				version = "v1",
				contact = @Contact(
						name = "Bharath H",
						email = "phani.bharath@gmail.com",
						url = "linked in url"),
				license = @License(
						name = "Social Security",
						url = "Social Security home page"
				)
		)
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
public class SocialsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialsecurityApplication.class, args);
	}
}
