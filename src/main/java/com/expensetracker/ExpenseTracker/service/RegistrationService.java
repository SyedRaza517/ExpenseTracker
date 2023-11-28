package com.expensetracker.ExpenseTracker.service;

import com.expensetracker.ExpenseTracker.Entities.Registration;
import com.expensetracker.ExpenseTracker.repositories.RegistoringCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistoringCustomer registoringCustomer;



    public String registerCustomer(String name,String email,String password,String confirmPassword){


        registoringCustomer.save(new Registration(name,email,password,confirmPassword));

        return "Customer has been registered";
    }


    public boolean checkUser(String email) {

       Optional<Registration> check = registoringCustomer.findByEmail(email);

       if(check.isEmpty()){
           return false;
       }
       else{
           return true;
       }
    }
}
