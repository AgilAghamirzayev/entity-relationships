package com.mastercode.entityrelationships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EntityRelationshipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityRelationshipsApplication.class, args);
	}

}
