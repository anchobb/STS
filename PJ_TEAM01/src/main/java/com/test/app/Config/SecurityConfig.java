package com.test.app.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.test.app.Config.auth.CustomAccessDeniedHandler;
import com.test.app.Config.auth.CustomAuthenticationEntryPoint;
import com.test.app.Config.auth.CustomAuthenticationFailureHandler;
import com.test.app.Config.auth.CustomLoginSuccessHandler;
import com.test.app.Config.auth.CustomLogoutHandler;
import com.test.app.Config.auth.CustomLogoutSuccessHandler;
import com.test.app.Config.auth.PrincipalDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	protected void confugure(HttpSecurity http) throws Exception{
		
		http.csrf().disable();
		
		http
			.authorizeRequests()
				.antMatchers("/", "/index").permitAll()
				.anyRequest().authenticated()
			.and()
			
			.formLogin()
			.loginPage("/login")
			.successHandler(new CustomLoginSuccessHandler())
			.failureHandler(new CustomAuthenticationFailureHandler())
			
			.and()
			.logout()
			.logoutUrl("/logout")
			.permitAll()
			.addLogoutHandler(new CustomLogoutHandler())
			.logoutSuccessHandler(new CustomLogoutSuccessHandler())
			
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
			.accessDeniedHandler(new CustomAccessDeniedHandler());
		
	}
	
	@Autowired
	private PrincipalDetailsService principalDetailsService;
	
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(principalDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
