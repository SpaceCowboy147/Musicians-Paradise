package com.dylansmusicshop.registration;


import com.dylansmusicshop.users.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

  @Autowired
  private UserRepo userRepository;
  @GetMapping("/registration")
  public String showRegistrationForm() {

    return "registration";
  }



}
