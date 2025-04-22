/*package com.abdul.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("${user.oauth.user.username}")
	private String username;
	
	@Value("${user.oauth.user.password}")
	private String password;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() { return new
	  BCryptPasswordEncoder(); }

	@Bean
	public UserDetailsService userDetailsService() {
		var uds = new InMemoryUserDetailsManager();
		uds.createUser(User.withUsername("admin").password("admin").authorities("read").build());
		uds.createUser(User.withUsername("admin").password("admin").authorities("write").build());
		return uds;
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		//auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("USER");
		http.httpBasic().and().cors().and().csrf().disable().authorizeRequests().anyRequest().permitAll();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.httpBasic().and()
		.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
						.permitAll()).csrf(AbstractHttpConfigurer::disable).build();
	}

}*/
