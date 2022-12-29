package com.dylansmusicshop.login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {

            response.setContentType("text/html");

            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(userName + password);


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicshop", "root", "1234");
            PreparedStatement validUser = connection.prepareStatement("SELECT * from users WHERE username = ? AND password = ?");
            validUser.setString(1, userName);
            validUser.setString(2, password);
          ResultSet userInput = validUser.executeQuery();
          userInput.next();
            connection.close();

            response.sendRedirect("/shopHome");



        }   catch (SQLException | IOException e) {
            throw new RuntimeException(e);

        }

    }
}
