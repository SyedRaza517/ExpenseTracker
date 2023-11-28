package com.expensetracker.ExpenseTracker.repositories;

import com.expensetracker.ExpenseTracker.Entities.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Records,Long> {
}
