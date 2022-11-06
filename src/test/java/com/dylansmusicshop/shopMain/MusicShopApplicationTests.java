package com.dylansmusicshop.shopMain;

import com.dylansmusicshop.registration.registerServlet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestExecutionListeners;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@TestExecutionListeners
@ContextConfiguration

class MusicShopApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void testRegisterUser() {
        registerServlet registerServlet = new registerServlet();
        registerServlet.getServletConfig();
        registerServlet.getServletInfo();


        }
    }


