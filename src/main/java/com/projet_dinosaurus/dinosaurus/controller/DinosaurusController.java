package com.projet_dinosaurus.dinosaurus.controller;

import com.projet_dinosaurus.dinosaurus.entity.Toy;
import com.projet_dinosaurus.dinosaurus.entity.Transaction;
import com.projet_dinosaurus.dinosaurus.entity.User;
import com.projet_dinosaurus.dinosaurus.repository.ToyRepository;
import com.projet_dinosaurus.dinosaurus.repository.TransactionRepository;
import com.projet_dinosaurus.dinosaurus.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DinosaurusController {
    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    /* @GetMapping("/toys")
    public List<Toy> getToys(@RequestParam(required = false) String sort) {
        List<Toy> toys = sort.isEmpty()? toyRepository.findAllToysAvailable() :
                toyRepository.findAllToysAvailableSorted(Sort.by(sort));
        return toys;
    } */

    @GetMapping("toys")
    public List<Toy> getToys() {
        return toyRepository.findAll();
    }

    @GetMapping("transactions")
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("toys/{id}")
    public Optional<Toy> getToyById(@PathVariable Long id) {
            Optional<Toy> toy = toyRepository.findById(id);
        return toy;
    }

    @PostMapping("/toys")
    public String addToy(@RequestBody Toy toy) {
        System.out.println(toy.available());
        toyRepository.save(toy);
        return "Post Toys Ok";
    }

    @PostMapping("/transactions")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @PostMapping("/users")
    public String addToy(@RequestBody User user) {
        System.out.println(user.getOwnerId());
        System.out.println(user.getFirstname());
        userRepository.save(user);
        return "post OK !";
    }

}
