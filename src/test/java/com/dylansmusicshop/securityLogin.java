//package com.dylansmusicshop;
//import org.apache.catalina.security.SecurityConfig;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.sql.DataSource;
//
//import static org.mockito.Mockito.*;
//
//
//public class securityLogin {
//    @Mock
//    private DataSource dataSource;
//
//    @InjectMocks
//    private SecurityConfig securityConfig;
//
//    @Test
//    void configureTest() throws Exception {
//        AuthenticationManagerBuilder authBuilder = mock(AuthenticationManagerBuilder.class);
//
//        securityConfig.configure(authBuilder);
//
//        verify(authBuilder).jdbcAuthentication();
//        verify(authBuilder).dataSource(dataSource);
//        verify(authBuilder).passwordEncoder(any(BCryptPasswordEncoder.class));
//        verify(authBuilder).usersByUsernameQuery("select username, password, enabled from users where username=?");
//        verify(authBuilder).authoritiesByUsernameQuery("select username, authorities from users where username=?");
//        verifyNoMoreInteractions(authBuilder);
//    }
//}

