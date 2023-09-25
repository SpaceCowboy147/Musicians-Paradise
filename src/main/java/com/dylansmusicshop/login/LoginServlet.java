package com.dylansmusicshop.login;

import com.dylansmusicshop.users.JdbcUser;
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

    private JdbcUser jdbcUser;

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {

            response.setContentType("text/html");

            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);



            ResultSet userInput = (ResultSet) jdbcUser.findByUsername(userName);
            String hashedPasswordFromDB = userInput.getString("password");
            String authority = userInput.getString("authorities");


                boolean passwordMatches = bCryptPasswordEncoder.matches(password, hashedPasswordFromDB);
                if (passwordMatches && authority.equals("user")) {
//                    userInput.next();
//                    connection.close();
                    response.sendRedirect("/shopHome");

                } else if (passwordMatches && authority.equals("admin")) {
                    response.sendRedirect("/admin");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin");
                    requestDispatcher.forward(request, response);
                }




        } catch (ServletException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

