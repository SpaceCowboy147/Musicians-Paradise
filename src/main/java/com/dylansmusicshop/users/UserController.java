package com.dylansmusicshop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.security.Principal;

@RestController
public class UserController {
    @Autowired
    JdbcUser jdbcUser;
@Autowired
UserRepo userRepository;
    @PostMapping("/changeUsername")
    public String changeUsername(@RequestParam("changeUsername") String userName,
                                 Principal principal) {
        String user = principal.getName();
        int userId = jdbcUser.findUserIdByUsername(user);
        User existingUser = userRepository.findByUsername(userName);
        if (existingUser == null) {

            jdbcUser.updateUsername(userId, userName);

            return "Updated username";
        } else {
            return "Username already exists";
        }
    }
    @PostMapping("/changePassword")
    public String changePassword( @RequestParam("changePassword") String password,
                                  @RequestParam("matchingPassword") String matchingPassword,
                                  Principal principal) {
        String user = principal.getName();
        int userId = jdbcUser.findUserIdByUsername(user);
        if (password.equals(matchingPassword)) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            String newPassword = passwordEncoder.encode(password);
            jdbcUser.updatePassword(newPassword, userId);

            return "Updated password";
        } else {
            return "Passwords do not match";
        }
    }
}
