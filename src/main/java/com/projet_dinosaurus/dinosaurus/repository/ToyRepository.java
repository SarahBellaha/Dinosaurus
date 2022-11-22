package com.projet_dinosaurus.dinosaurus.repository;

import com.projet_dinosaurus.dinosaurus.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToyRepository extends JpaRepository <Toy, Long> {
//
//    @Query(value = "SELECT * from toy t WHERE t.available = 0",
//    nativeQuery = true)
//    List<Toy> findAllToysAvailable();
//
//    @Query(value = "SELECT t from toy t WHERE t.available = 0")
//    List<Toy> findAllToysAvailableSorted(Sort sort);
}
