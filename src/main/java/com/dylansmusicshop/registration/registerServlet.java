package com.dylansmusicshop.registration;


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
public class registerServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/html");

            String userName = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String matchingPassword = request.getParameter("password_confirmation");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicshop", "root", "1234");

            PreparedStatement registerUser = connection.prepareStatement("INSERT into users(username, role, password, address, email) values(?,?,?,?,?)");
            registerUser.setString(1, userName);
            registerUser.setString(2, "user");
            registerUser.setString(3, password);
            registerUser.setString(4, "123 street, Statesota");
            registerUser.setString(5, email);
            registerUser.executeUpdate();
           connection.close();
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully inserted"
                    + "</b></body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        }

        }

    }


