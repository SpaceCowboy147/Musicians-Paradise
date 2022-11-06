package com.dylansmusicshop.registration;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {


  @GetMapping("/registration")
  public String showRegistrationForm() {
//    UserDTO userDto = new UserDTO();
//    model.addAttribute("user", userDto);
    return "registration";
  }

  @PostMapping
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDTO userDto,
                                            HttpServletRequest request, Errors errors) {
      return null;
    }
}
