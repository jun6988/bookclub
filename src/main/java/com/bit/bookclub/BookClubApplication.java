package com.bit.bookclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.validation.Errors;

import com.bit.bookclub.infra.config.ErrorsSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BookClubApplication {

	// 
	public static void main(String[] args) {
		SpringApplication.run(BookClubApplication.class, args);
	}
	
	
	// SELIZER 해결방2(WITH ErrorsSerializer+
	@Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //1.
        objectMapper = Jackson2ObjectMapperBuilder
                            .json()
                            .serializerByType(Errors.class, new ErrorsSerializer())
                            .build();
                            
        return objectMapper;
	}

}
