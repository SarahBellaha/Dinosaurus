package com.projet_dinosaurus.dinosaurus.repository;

import com.projet_dinosaurus.dinosaurus.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository <Transaction, Long> {
}
