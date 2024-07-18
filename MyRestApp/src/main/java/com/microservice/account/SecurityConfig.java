package com.microservice.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 

	/* configure filter chain for apis */
	@Bean //<-- to register this filterchain with spring 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer:: disable)
            .authorizeHttpRequests(authorize -> authorize
            	.antMatchers(HttpMethod.GET,"/api/employee/getall").permitAll()	
            	.antMatchers(HttpMethod.POST,"/api/employee/add").permitAll()
                .anyRequest().denyAll()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
	
	/* AuthenticationManager : in-memory / jdbc */
}
