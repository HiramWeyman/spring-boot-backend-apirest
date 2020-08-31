package com.tesoreria.springboot.backend.apirest;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class ServletInitializer {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(SpringBootBackendApirestApplication.class);
	}

}
