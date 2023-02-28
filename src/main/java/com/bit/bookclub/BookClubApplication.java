package com.bit.bookclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BookClubApplication {

	// 
	public static void main(String[] args) {
		SpringApplication.run(BookClubApplication.class, args);
	}

}
