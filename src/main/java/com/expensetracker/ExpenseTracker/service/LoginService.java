package com.expensetracker.ExpenseTracker.service;

import com.expensetracker.ExpenseTracker.Entities.Login;
import com.expensetracker.ExpenseTracker.Entities.Records;
import com.expensetracker.ExpenseTracker.Entities.Registration;
import com.expensetracker.ExpenseTracker.repositories.RecordRepository;
import com.expensetracker.ExpenseTracker.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private RecordRepository recordRepository;

    public Registration validates(String username , String password){

        return registrationRepository.findByNameAndPassword(username,password);
    }


    public List<Records> getAllRecords() {

        return recordRepository.findAll();

    }
}
