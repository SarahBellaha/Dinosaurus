package com.projet_dinosaurus.dinosaurus.repository;

import com.projet_dinosaurus.dinosaurus.entity.Toy;
import com.projet_dinosaurus.dinosaurus.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long> {

    @Query(value = "SELECT * from toy t WHERE t.ownerId = ?",
            nativeQuery = true)
    List<Toy> findAllRequests(Long id);

     @Query(value = "SELECT * from toy t WHERE t.takerId = ?",
            nativeQuery = true)
    List<Toy> findAllReservations(Long id);

  /*  @Query(value = "select t from transaction t"
    + "inner join t.tradedToy j"
    + "where t.owner = id"
    + "order by j.name asc")
    List<Toy> findAllRequests(Long id); */

    /* @Query(value = "select t from transaction t"
    + "inner join t.tradedToy j"
    + "where t.taker = id"
    + "order by j.name asc")
    List<Toy> findAllReservations(Long id); */
}
