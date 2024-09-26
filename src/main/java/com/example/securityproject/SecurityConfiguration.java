package com.example.securityproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("Ananth").password("$2a$12$72ciA.9KDj5FSvgmRViWp.I13C4xVUFQzsJxA7GF7HMBrWO18NAAu").roles("Student");
//	}

//	@Bean
//	public PasswordEncoder getPassword() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	//Authentication
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("Ananth").password("$2a$12$72ciA.9KDj5FSvgmRViWp.I13C4xVUFQzsJxA7GF7HMBrWO18NAAu").roles("Student");
//	}
//	@Bean
//	public PasswordEncoder getPassword() {
//		return new BCryptPasswordEncoder(12);
//	}
	
	//Authorization
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Ananth").password("$2a$12$6Uvyq3p188XoujqAyTOhU.Bm85TqEAzeoxXoTrZ4cKE/xrRyC/v.S").roles("Student")
		.and().withUser("Kumar").password("$2a$12$q5ShGVHXNRSppBeKnSpz3OJTUW0pCnQo1j83/vIB9BzGkARWsbiGK").roles("teacher").and().withUser("Karthi").
		password("$2a$12$3lZ3Y667f.FlWdDihNt5a.3sTYxaT7fmCp27060MSeahpGUFqam9S").roles("manager");
	}
	
	@Bean
	public PasswordEncoder getPassword() {
		return new BCryptPasswordEncoder(12);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/getManager").hasRole("manager");
		http.authorizeRequests().antMatchers("/getTeacher").hasAnyRole("teacher","manager");
		http.authorizeRequests().antMatchers("/getStudent").permitAll().and().formLogin();
	}
	
}
