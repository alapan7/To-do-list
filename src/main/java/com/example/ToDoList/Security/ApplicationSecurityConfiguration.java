package com.example.ToDoList.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsServiceObject;

    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceObject);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/displayRecord").hasAnyAuthority("MANAGER","ADMIN")
                .antMatchers("/addTaskDetails").hasAnyAuthority("USER","MANAGER")
                .antMatchers("/findById/{empId}").hasAnyAuthority("USER","MANAGER")
                .antMatchers("/findByMail/{email}").hasAuthority("ADMIN")
                .antMatchers("/findByName/{name}").hasAuthority("ADMIN")
                .antMatchers("/findByProject").hasAuthority("ADMIN")
                .antMatchers("/deleteById/{empId}").hasAuthority("MANAGER")
                .antMatchers("/update/{id}").hasAnyAuthority("MANAGER","ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }
}
