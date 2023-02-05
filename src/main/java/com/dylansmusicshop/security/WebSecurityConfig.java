package com.dylansmusicshop.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
           auth.jdbcAuthentication()
                   .dataSource(dataSource)
                   .usersByUsernameQuery("select username, password, enabled from users where username=?")
                   .authoritiesByUsernameQuery("select username, authorities from users where username=?")
                   .passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()


        //        http.csrf().disable()
             //   .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("user")
//                .antMatchers("/guest**").anonymous()
//                        .antMatchers("/registrationServlet").hasRole("user")
//
//                        //.antMatchers("/shopHome").//shophome and registration are permit all until form login works
//                     //   .antMatchers("/registration").permitAll()
//                        .antMatchers("/login").permitAll()
//                .anyRequest()
//                .authenticated()
//
//                .and()
                .formLogin()
//                .loginPage("/login")
//                        .loginProcessingUrl("/loginServlet")
//                .defaultSuccessUrl("/shopHome", true)
//                .failureUrl("/login-error")


                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID");

    }


    }







