package com.projet_dinosaurus.dinosaurus.repository;

import com.projet_dinosaurus.dinosaurus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
