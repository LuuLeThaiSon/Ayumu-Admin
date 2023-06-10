package com.example.ayumuadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Resource
	private UserDetailsService userDetailsService;
	@Resource
	private JwtRequestFilter jwtRequestFilter;
	@Resource
	private AppConfig appConfig;

	@Resource
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(appConfig.passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/ayumu/v1/auth/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.and().sessionManagement()
			.sessionCreationPolicy(STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
