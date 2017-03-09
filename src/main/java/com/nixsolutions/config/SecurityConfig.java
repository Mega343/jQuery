package com.nixsolutions.config;

import com.nixsolutions.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .usernameParameter("j_email")
                .passwordParameter("j_password")
                .defaultSuccessUrl("/main")
                .permitAll();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("Admin")
                .antMatchers("/delete/**").hasRole("Admin")
                .antMatchers("/update_user/**").hasRole("Admin")
                .antMatchers("/update/**").hasRole("Admin")
                .antMatchers("/address/**").hasRole("Admin")
                .antMatchers("/document/**").hasRole("Admin")
                .antMatchers("/awaiting_confirmation/**").hasRole("Admin")
                .antMatchers("/books/**").hasRole("Admin")
                .antMatchers("/book_delete/**").hasRole("Admin")
                .antMatchers("/book_description/**").hasRole("Admin")
                .antMatchers("/update_book/**").hasRole("Admin")
                .antMatchers("/add_book/**").hasRole("Admin")
                .antMatchers("/add_order/**").hasRole("Admin")
                .antMatchers("/close/**").hasRole("Admin")
                .antMatchers("/orders/**").hasRole("Admin")
                .antMatchers("/home/**").permitAll()
                .antMatchers("/main/**").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/registration/**").permitAll()
                .antMatchers("/add_user/**").permitAll();
    }

}
