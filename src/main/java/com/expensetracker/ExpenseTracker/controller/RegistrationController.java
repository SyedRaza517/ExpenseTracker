package com.expensetracker.ExpenseTracker.controller;

import com.expensetracker.ExpenseTracker.service.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    public ModelAndView modelAndView  = new ModelAndView();

    @RequestMapping("/registerPage")
    public ModelAndView SignUpPage(){

        modelAndView.setViewName("SignUp.html");
        return modelAndView;
    }


@PostMapping(value = "/register")
    public ModelAndView addNewUser(HttpServletRequest httpServletRequest){

    String name = httpServletRequest.getParameter("name");
    String email = httpServletRequest.getParameter("email");
    String password = httpServletRequest.getParameter("password");
    String confirmPassword = httpServletRequest.getParameter("confirm_password");

    System.out.println(name);
    System.out.println(email);
    System.out.println(password);
    System.out.println(confirmPassword);

    // Checking either same user is registered with same email or not.

    boolean checkEmail = registrationService.checkUser(email);

    if(checkEmail){
        String emailIsPresent = "Email is already exist please try with another one";
        System.out.println(emailIsPresent);
        return new ModelAndView("SignUp.html","emailExist",emailIsPresent);
    }
    else {
        if(password.equals(confirmPassword)){
            registrationService.registerCustomer(name,email,password,confirmPassword);
            modelAndView.setViewName("index.html");
            return modelAndView;
        }
        else {
            String passNotMatch = "Password and Confirm Password does not match?";
            System.out.println(passNotMatch);
            return new ModelAndView("SignUp.html","passwordMacthing",passNotMatch);
        }



    }




}
}
