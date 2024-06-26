package com.example.carbuddy.security;

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
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers("/about").permitAll()
				.antMatchers(HttpMethod.GET, "/contact").permitAll()
				.antMatchers(HttpMethod.POST, "/contact").permitAll()
				.antMatchers(HttpMethod.GET, "/register").permitAll()
				.antMatchers(HttpMethod.POST, "/register/new").permitAll()
				.antMatchers(HttpMethod.GET, "/cars").permitAll()
				.antMatchers(HttpMethod.GET, "/cars/new").permitAll()
				.antMatchers(HttpMethod.POST, "/cars/new").permitAll()
				.antMatchers(HttpMethod.POST, "/search").permitAll()
				.antMatchers(HttpMethod.GET, "/dashboard").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/cars")
				.usernameParameter("username")
				.permitAll()
				.and()
			.logout()
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/")
				.permitAll();
		
		return http.build();
	}
}
