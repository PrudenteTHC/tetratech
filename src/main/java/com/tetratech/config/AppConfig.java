package com.tetratech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.tetratech.restservice")
public class AppConfig {

	@Bean
	RestTemplate restTemplate() {
        return new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
	}
}