package com.dylansmusicshop.login;

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

        try {

            response.setContentType("text/html");

            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("userName" + ": " + userName + " " + "password" + ": " + password);

           // BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicshop", "root", "1234");
            PreparedStatement validUser = connection.prepareStatement("SELECT username FROM users WHERE username=? AND password=?");
            validUser.setString(1, userName);
            validUser.setString(2, password);
            ResultSet userInput = validUser.executeQuery();
            userInput.next();
            connection.close();
            response.sendRedirect("/shopHome");
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully logged in"
                    + "</b></body></html>\n" +
                    "<div class=\"topCushion\">Continue to shop <a href=\"shopHome\">Continue</a></div>");
            response.wait(3000);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shopHome");
    requestDispatcher.forward(request, response);

            } catch (SQLException | InterruptedException | IOException | ServletException ex) {
            throw new RuntimeException(ex);

        }

    }
}
