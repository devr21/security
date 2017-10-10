package learn.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecureWebAppConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/","/auth").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/auth/")
				.loginProcessingUrl("/perform_login")
		        .failureUrl("/auth?error=true")
		        .and()
		    .logout()
		        .logoutUrl("/perform_logout")
		        .logoutSuccessUrl("/")
		        .deleteCookies("JSESSIONID")
				.and()
			.httpBasic()
				.and()
			.exceptionHandling()
				.accessDeniedPage("/auth/accessDenied")
				.and()
			.csrf().disable();
	}
	
	/*@Bean
	@Override
	public UserDetailsService userDetailsService(){
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("admin").password("admin").roles("ADMIN").build());
		manager.createUser(User.withUsername("user").password("pass").roles("USER").build());
		
		return manager;
	}*/
	
	@Autowired
	@Qualifier("myUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		/*.passwordEncoder(new BCryptPasswordEncoder());*/
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
}
