package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfig extends WsConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
	}
}
