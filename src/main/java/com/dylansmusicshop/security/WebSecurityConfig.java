package com.dylansmusicshop.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("password")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("123")).roles("ADMIN", "USER");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        AuthenticationSuccessHandler myAuthenticationSuccessHandler = null;
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/guest*").anonymous()
                .antMatchers("/login*").permitAll()
                .anyRequest()
                .authenticated()

                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/logging-in")
                .defaultSuccessUrl("/shopHome", true)
                .failureUrl("/login-error")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler((AuthenticationFailureHandler) authenticationManager())

                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
              //  .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID");
        // .logoutSuccessHandler(logoutSuccessHandler());

    }
//    @Configuration
//    @ImportResource({ "classpath:webSecurityConfig.xml" })
//    public class SecSecurityConfig {
//        public SecSecurityConfig() {
//            super();
//        }
    }







