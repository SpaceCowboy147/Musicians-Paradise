package com.dylansmusicshop.shopMain;

import com.dylansmusicshop.registration.registerServlet;
import com.dylansmusicshop.security.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.assertTrue;


//@SpringBootTest
//@TestExecutionListeners
//@ContextConfiguration
//
class MusicShopApplicationTests {
    @Test
    void testLogin() {
        PasswordEncoder passwordEncoder = new PasswordEncoder();


    }
//
//    @Test
//    void contextLoads() {
//
//    }
//
//    @Test
//    public void testRegisterUser() {
//        registerServlet registerServlet = new registerServlet();
//
//   registerServlet.getServletConfig();
//        registerServlet.getServletInfo();

        }
//    }


