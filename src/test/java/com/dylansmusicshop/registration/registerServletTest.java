package com.dylansmusicshop.registration;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import static org.mockito.Mockito.*;
//
//class registerServletTest {
//@Test
//    public void testRegistration() throws Exception {
//    try {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//        when(request.getParameter("username")).thenReturn("user");
//        when(request.getParameter("password")).thenReturn("147");
//        when(request.getParameter("email")).thenReturn("email@yahoo.com");
//        new RegisterServlet().doPost(request, response);
//        verify(request, atLeast(1)).getParameter("username");
////        String userName = "username";
////        String email = "email@yahoo.com";
////        String password ="password";
////        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
////       // passwordEncoder.encode(password);
////        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicshop", "root", "1234");
////
////        PreparedStatement registerUser = connection.prepareStatement("INSERT into users(username, authorities, password, address, email) values(?,?,?,?,?)");
////        registerUser.setString(1, userName);
////        registerUser.setString(2, "user");
////        registerUser.setString(3, passwordEncoder.encode(password));
////        registerUser.setString(4, "");
////        registerUser.setString(5, email);
////        registerUser.executeUpdate();
////        connection.close();
////        System.out.println(passwordEncoder.encode(password));
////        System.out.println(password);
////
////    } catch (SQLException e) {
////        throw new RuntimeException(e);
////    }
//
//
//    } catch (ServletException e) {
//        throw new RuntimeException(e);
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//}
//}