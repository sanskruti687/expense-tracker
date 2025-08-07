package com.sits.repository;

import com.sits.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find expenses by category
    List<Expense> findByCategory(String category);

    // Find expenses by date range
    List<Expense> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);

    // Find expenses by category and date range
    List<Expense> findByCategoryAndExpenseDateBetween(String category, LocalDate startDate, LocalDate endDate);

    // Get total amount by category
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.category = :category")
    BigDecimal getTotalAmountByCategory(String category);

    // Get total amount for all expenses
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e")
    BigDecimal getTotalAmount();

    // Find all expenses ordered by date (newest first)
    List<Expense> findAllByOrderByExpenseDateDesc();
}