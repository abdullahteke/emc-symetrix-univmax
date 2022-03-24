package com.abdullahteke.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

@Configuration
public class AppBeanConfig {
	
    @Value("${emc.userName}")
    private String restUser;
    
    @Value("${emc.userPassword}")
    private String restUserPassword;
    


    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .additionalInterceptors(new BasicAuthenticationInterceptor(restUser,restUserPassword))
                .build();
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        
    	ObjectMapper retVal= new ObjectMapper();
    	retVal.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    	return retVal;
    }
}
