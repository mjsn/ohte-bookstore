package fi.haagahelia.ohte.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.haagahelia.ohte.bookstore.web.UserDetailServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/css/**").permitAll()
				.and()
			.authorizeRequests()
			.antMatchers("/", "add", "save", "booklist").permitAll()
			.antMatchers("/delete/{id}").hasAuthority("ADMIN")
			.anyRequest().authenticated()
				.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/booklist")
			.permitAll()
				.and()
			.logout()
			.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}