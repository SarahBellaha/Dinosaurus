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
@CrossOrigin("*")
public class DinosaurusController {
    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;


    // ----------- TOYS ROUTES ------------

   //            --- ALL TOYS ---
    @GetMapping("toys")
    public List<Toy> getToys() {
        return toyRepository.findAll();
    }

    //          --- TOYS BY ID ---

    @GetMapping("toys/{id}")
    public Optional<Toy> getToyById(@PathVariable Long id) {
        Optional<Toy> toy = toyRepository.findById(id);
        return toy;
    }

    //            --- POST TOY ---

    @PostMapping("/users/{userId}/toys")
    public ResponseEntity<Toy> createToy(@PathVariable(value = "userId") Long userId, @RequestBody Toy toy) {
        Toy newToy = userRepository.findById(userId).map(user -> {
            toy.setUser(user);
            return toyRepository.save(toy);
        }).orElseThrow(() -> new MissingResourceException("No user found for this id...", "User", ""));
        return new ResponseEntity<>(newToy, HttpStatus.CREATED);
    }

    //      --- UPDATE TOY'S AVAILABILITY ---

    @PutMapping("/toys/{id}")
    public Toy updateAvailability(@PathVariable Long id) {
        Toy toy = toyRepository.findById(id).orElse(null);
        toy.setAvailable(!toy.isAvailable());
        toyRepository.save(toy);
        return toy;
    }

    //            --- DELETE TOY ---

    @DeleteMapping("toys/{id}")
    public ResponseEntity deleteToy(@PathVariable Long id) {
        toyRepository.deleteById(id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }



    // ----------------- USERS -------------------

    //              --- ALL USERS ---
    @GetMapping("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //              --- USER'S TOYS ---

    @GetMapping("users/toys/{id}")
    public List<Toy> getUserToys(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get().getToys();
    }

    //            --- USER'S REQUESTS ---

    @GetMapping("users/requests/{owner_id}")
    public List<Transaction> getUserRequests(@PathVariable Long owner_id) {
        List<Transaction> requests = transactionRepository.findAllRequests(owner_id);
        return requests;
    }

    //          --- USER'S RESERVATIONS ---

    @GetMapping("users/reservations/{taker_id}")
    public List<Transaction> getUserReservations(@PathVariable Long taker_id) {
        List<Transaction> requests = transactionRepository.findAllReservations(taker_id);
        return requests;
    }


    //              --- USER BY ID ---

    @GetMapping("users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    //              --- POST USER ---

    @PostMapping("/users")
    public String addToy(@RequestBody User user) {
        userRepository.save(user);
        return "post OK !";
    }

    //              --- DELETE USER ---

    @DeleteMapping("users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    // ______________ TRANSACTIONS ________________

    //           --- ALL TRANSACTIONS ---

    @GetMapping("transactions")
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    //           --- POST TRANSACTION ---

    @PostMapping("/users/{takerUserId}/{tradedToy}/transactions")
    public ResponseEntity<Transaction> createToy(@PathVariable(value = "takerUserId") Long takerUserId,
                                                 @PathVariable(value = "tradedToy") Long tradedToy,
                                                 @RequestBody Transaction transaction) {

        // -- set Owner and taker
        Transaction newTransaction = userRepository.findById(takerUserId).map(user -> {
            transaction.setToyTaker(user);
            transaction.setTradedToy(toyRepository.findById(tradedToy).get());
            System.out.println(transaction.getTradedToy().getUser().getFirstname());
            return transactionRepository.save(transaction);
        }).orElseThrow(() -> new MissingResourceException("No user found for this id...", "User", ""));

        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    //            --- DELETE TRANSACTION ---

    @DeleteMapping("transactions/{id}")
    public ResponseEntity deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

}
