package com.dylansmusicshop.registration;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/registrationServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            response.setContentType("text/html");

            String  username = request.getParameter("username");
            String  email = request.getParameter("email");
            String password = request.getParameter("password");
            String matchingPassword = request.getParameter("password_confirmation");

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            System.out.println(username + email + password);


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicshop", "root", "1234");
            PreparedStatement registerUser = connection.prepareStatement("INSERT into users(username, authorities, password, address, email, enabled) values(?,?,?,?,?,?)");
            registerUser.setString(1, username);
            registerUser.setString(2, "user");
            registerUser.setString(3, passwordEncoder.encode(password));
            registerUser.setString(4, " ");
            registerUser.setString(5, email);
            registerUser.setInt(6, 1);
            registerUser.executeUpdate();
            connection.close();
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully inserted"
                    + "</b></body></html>\n" +
                    "<div class=\"topCushion\">Continue to login <a href=\"login\">Continue</a></div>");
        } catch (Exception e) {

           e.printStackTrace();
           System.out.println(e);
        }

    }
    }




