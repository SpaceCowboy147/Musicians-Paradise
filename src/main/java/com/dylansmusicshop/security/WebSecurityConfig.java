package com.dylansmusicshop.security;


import com.dylansmusicshop.login.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//           auth.jdbcAuthentication()
//                   .passwordEncoder(new BCryptPasswordEncoder())
//                   .dataSource(dataSource)
//                   .usersByUsernameQuery("select username, password, enabled from users where username=?")
//                   .authoritiesByUsernameQuery("select username, authorities from users where username=?");

        //USING in memory because I keep getting an error saying my passwords aren't BCrypt. Had to follow youtube tutorial and still got the same error.
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("test"))
                .roles("user");
    }




    @Override
    protected void configure(final HttpSecurity http) throws Exception {

                http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/guest**").anonymous()


                        .antMatchers("/shopHome").hasRole("user")//shophome and registration are permit all until form login works
                        .antMatchers("/registration").permitAll()
                        .antMatchers("/registrationServlet").permitAll()
                        .antMatchers("/login").permitAll()
                .anyRequest()
                .authenticated()

               .and()
                .formLogin()
                .loginPage("/login")
                        .loginProcessingUrl("/loginServlet")
                .defaultSuccessUrl("/shopHome", true)
                .failureUrl("/login-error")


                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID");

    }


    }







