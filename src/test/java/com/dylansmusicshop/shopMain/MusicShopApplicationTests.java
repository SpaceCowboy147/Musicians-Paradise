package com.dylansmusicshop.shopMain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@TestExecutionListeners
@ContextConfiguration

class MusicShopApplicationTests {
    @Test
    void passWordEncoderTest() throws Exception{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("username")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("pass");
        when(request.getParameter("email")).thenReturn("test@yahoo.com");
       // new RegisterServlet().doPost(request, response);
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


