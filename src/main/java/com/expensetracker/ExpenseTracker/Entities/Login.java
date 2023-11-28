package com.expensetracker.ExpenseTracker.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Login {

    private Long id;
    private String username;
    private String password;


}
