package com.projet_dinosaurus.dinosaurus.repository;


import com.projet_dinosaurus.dinosaurus.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long> {

    @Query(value = "SELECT * from toy t WHERE toy_owner_id = ?",
            nativeQuery = true)
    List<Transaction> findAllRequests(Long id);

     @Query(value = "select * from transaction where taker_user_id = ?",
            nativeQuery = true)
     List<Transaction> findAllReservations(Long id);


}
