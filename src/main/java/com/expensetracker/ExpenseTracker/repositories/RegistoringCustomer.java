package com.expensetracker.ExpenseTracker.repositories;

import com.expensetracker.ExpenseTracker.Entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistoringCustomer extends JpaRepository<Registration, Long> {


        public Optional<Registration> findByEmail(String email);

}
