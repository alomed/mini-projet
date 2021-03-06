package de.tekup.project.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
	        http.cors()
	            .and()
	              .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/client/commande")
	                  .hasAuthority("SCOPE_read")
	                .antMatchers(HttpMethod.POST, "/client/writecommande").hasAuthority("SCOPE_write")
	                  .anyRequest()
	                  .authenticated()
	            .and()
	              .oauth2ResourceServer()
	                .jwt();
	    }
	

	
	
}
