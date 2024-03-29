package com.dylansmusicshop.registration;


import com.dylansmusicshop.shop.repositories.CartRepo;
import com.dylansmusicshop.users.User;
import com.dylansmusicshop.users.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/registrationServlet")
public class RegisterServlet extends HttpServlet {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private CartRepo cartRepository;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {

            response.setContentType("text/html");

            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String matchingPassword = request.getParameter("password_confirmation");


            User existingUser = userRepository.findByUsername(username);


            if (existingUser != null) {
                PrintWriter out = response.getWriter();
                out.println("<html><body><b>User with this username already exists."
                        + "</b></body></html>\n");

            } else if  (password.equals(matchingPassword)) {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
                User user = new User();
                user.setUsername(username);
                user.setPassword(passwordEncoder.encode(password));
                user.setEmail(email);
                user.setAuthorities("user");
                user.setEnabled(true);
               userRepository.save(user);
int userId = userRepository.findUserIdByUsername(username);


               System.out.println("ID:" + userId);
                cartRepository.saveUserWithCartId(userId);

                PrintWriter out = response.getWriter();
                out.println("<html><body><b>Successfully inserted"
                        + "</b>\n" +
                        "<div class=\"topCushion\">Continue to login <a href=\"login\">Continue</a></div></body></html>");
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body><b>Passwords do not match"
                        + "</b></body></html>\n");
            }
        } catch (Exception e) {

           e.printStackTrace();
           System.out.println(e);
        }

    }
    }




