package com.example.carbuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.carbuddy.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService());
		auth.setPasswordEncoder(passwordEncoder());
		
		return auth;
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.GET, "/api/bids").permitAll()
				.antMatchers(HttpMethod.GET, "/api/bids/*").permitAll()
				.antMatchers(HttpMethod.POST, "/api/bids").permitAll()
				.antMatchers(HttpMethod.PUT, "/api/bids/*").permitAll()
				.antMatchers(HttpMethod.DELETE, "/api/bids/*").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/auction")
				.usernameParameter("username")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/signin")
				.permitAll();
		
		return http.build();
	}
}
