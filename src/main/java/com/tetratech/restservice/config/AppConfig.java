package com.tetratech.restservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.tetratech.restservice")
public class AppConfig {

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
//		MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
//		converter.setObjectMapper(new ObjectMapper());
//		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}
}