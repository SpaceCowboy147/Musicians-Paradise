package com.dylansmusicshop.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
GrantedAuthority authority;
        try {

            response.setContentType("text/html");

            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicshop", "root", "1234");
            PreparedStatement validUser = connection.prepareStatement("SELECT password FROM users WHERE username=?");
            validUser.setString(1, userName);
            validUser.setString(2, password );
            ResultSet userInput = validUser.executeQuery();
            if (userInput.next()) {
                String hashedPasswordFromDB = userInput.getString("password");


                boolean passwordMatches = bCryptPasswordEncoder.matches(password, hashedPasswordFromDB);
                if (passwordMatches) {
                    userInput.next();
                    connection.close();
                    response.sendRedirect("/shopHome");
                    response.wait(3000);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shopHome");
                    requestDispatcher.forward(request, response);
                }

            }

        } catch (ServletException | IOException | SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

