package com.projet_dinosaurus.dinosaurus.repository;

import com.projet_dinosaurus.dinosaurus.entity.Transaction;
import com.projet_dinosaurus.dinosaurus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    @Query(value = "SELECT * from user t WHERE email = ?",
            nativeQuery = true)
    User findUserByEmail(String email);

}
