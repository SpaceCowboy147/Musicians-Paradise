package com.dylansmusicshop.registration;


import com.dylansmusicshop.shop.repositories.CartRepo;
import com.dylansmusicshop.users.User;
import com.dylansmusicshop.users.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/registrationServlet")
public class RegisterServlet extends HttpServlet {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    public CartRepo cartRepo;
    @Transactional
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

                if (cartRepo.UserIdExistsWithCartId(user.getID())) {
                    cartRepo.saveUserWithCartId(user.getID());
                }

                PrintWriter out = response.getWriter();
                out.println("<html><body><b>Successfully inserted"
                        + "</b></body></html>\n" +
                        "<div class=\"topCushion\">Continue to login <a href=\"login\">Continue</a></div>");
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


//

