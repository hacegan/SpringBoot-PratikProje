package samet.proje.projem.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Guvenlik_Config extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.
		csrf().disable()
		.authorizeRequests()
			.antMatchers("/", "/anasayfa").permitAll();
			//.anyRequest().authenticated();
			/*.and()
		.formLogin()
			.permitAll()
			.and()
		.logout()
			.permitAll();*/
		
		
		
       //http.csrf().disable();
		
		/*http.authorizeRequests().antMatchers("/","/anasayfa").permitAll().anyRequest().authenticated()
		 .and().formLogin()
			.permitAll().and().exceptionHandling().accessDeniedPage("/hata").and().
		  logout().logoutUrl("/cikis")
		  .clearAuthentication(true).invalidateHttpSession(true).deleteCookies(
		  "JSSESIONID", "remember-me") .logoutSuccessUrl("/").and().csrf().and().cors().disable();*/
		 
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.jdbcAuthentication().dataSource(dataSource); }
	 */

}
