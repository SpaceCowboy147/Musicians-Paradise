package com.dylansmusicshop.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {

            response.setContentType("text/html");

            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(userName + password);


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicshop", "root", "1234");
            PreparedStatement validUser = connection.prepareStatement("SELECT username FROM users WHERE username=? AND password=?");
            ResultSet userInput = validUser.executeQuery();
            userInput.next();
                response.sendRedirect("/shopHome");
                connection.close();



            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }
}
