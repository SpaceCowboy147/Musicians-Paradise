//package com.dylansmusicshop;
//
//import com.dylansmusicshop.login.LoginServlet;
//import org.junit.jupiter.api.Test;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.io.PrintWriter;
//
//import static org.mockito.Mockito.*;
//
//public class Login {
//    @Test
//    public void testLogin() {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//        when(request.getParameter("username")).thenReturn("user");
//        when(request.getParameter("password")).thenReturn("123");
//        new LoginServlet().doPost(request, response);
//
//        verify(request, atLeast(1)).getParameter("username");
//    }
//}