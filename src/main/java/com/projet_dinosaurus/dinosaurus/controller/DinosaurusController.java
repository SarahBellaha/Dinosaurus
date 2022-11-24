package com.projet_dinosaurus.dinosaurus.controller;

import com.projet_dinosaurus.dinosaurus.entity.*;
import com.projet_dinosaurus.dinosaurus.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class DinosaurusController {
    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;


    /*
     * @GetMapping("/toys") public List<Toy> getToys(@RequestParam(required = false) String sort) {
     * List<Toy> toys = sort.isEmpty()? toyRepository.findAllToysAvailable() :
     * toyRepository.findAllToysAvailableSorted(Sort.by(sort)); return toys; }
     */

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
    // ----------------------------------------
    /*
     * @PostMapping("/toys") public String addToy(@RequestBody Toy toy) {
     * 
     * System.out.println(toy.getOwner()); toyRepository.save(toy); return "Post Toys Ok"; }
     */

    @PostMapping("/users/{userId}/toys")
    public ResponseEntity<Toy> createToy(@PathVariable(value = "userId") Long userId,
            @RequestBody Toy toy) {
        Toy newToy = userRepository.findById(userId).map(user -> {
            toy.setUser(user);
            return toyRepository.save(toy);
        }).orElseThrow(
                () -> new MissingResourceException("No user found for this id...", "User", ""));
        return new ResponseEntity<>(newToy, HttpStatus.CREATED);
    }

    // _________________________________________

    @PostMapping("/transactions")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @PostMapping("/users")
    public String addToy(@RequestBody User user) {
        userRepository.save(user);
        return "post OK !";
    }

}
