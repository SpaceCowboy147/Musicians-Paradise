package com.dylansmusicshop.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

           auth.jdbcAuthentication()
                   .dataSource(dataSource)
                   .passwordEncoder(new BCryptPasswordEncoder())
                   .usersByUsernameQuery("select username, password, enabled from users where username=?")
                   .authoritiesByUsernameQuery("select username, authorities from users where username=?");

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {


                http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin").hasRole("admin")
                .antMatchers("/user").hasRole("user")
                .antMatchers("/guest").anonymous()
                        .antMatchers("/shopHome").permitAll()
                        .antMatchers("/products").permitAll()
                        .antMatchers("/registration").permitAll()
                        .antMatchers("/registrationServlet").permitAll()
                        .antMatchers("/login").permitAll()
                        .antMatchers("/products/**", "/guitars", "/drums", "/accessories").permitAll()
                        .antMatchers("/addToCart").permitAll()
                        .antMatchers("/loginServlet").permitAll()
                        .antMatchers("/admin").hasAuthority("admin")
                        .antMatchers("/user/**").hasRole("user")
        .antMatchers("/images/**").permitAll()

                .anyRequest()
                .authenticated()

               .and()
                .formLogin()
                .loginPage("/login")
                        .loginProcessingUrl("/loginServlet")
                .defaultSuccessUrl("/dashboard", true)
                .failureUrl("/login-error")


                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID");

    }


    }







