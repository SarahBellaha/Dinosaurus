package com.projet_dinosaurus.dinosaurus.controller;

import com.projet_dinosaurus.dinosaurus.entity.Toy;
import com.projet_dinosaurus.dinosaurus.entity.Transaction;
import com.projet_dinosaurus.dinosaurus.entity.User;
import com.projet_dinosaurus.dinosaurus.repository.ToyRepository;
import com.projet_dinosaurus.dinosaurus.repository.TransactionRepository;
import com.projet_dinosaurus.dinosaurus.repository.UserRepository;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
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

    // GET ALL
    @GetMapping("/toys")
    public List<Toy> getToys(@RequestParam(required = false) String sort) {
        List<Toy> toys = sort.isEmpty() ? toyRepository.findAllToysAvailable()
                : toyRepository.findAllToysAvailableSorted(Sort.by(sort));
        return toys;
    }

    @GetMapping("/users")
    public List<User> getUsers(UserRepository users) {
        return userRepository.findAll();
    }

    @GetMapping("/transaction")
    public List<Transaction> getTransactions(TransactionRepository transactions) {
        return transactionRepository.findAll();
    }

    // GET BY ID
    @GetMapping("user/{id}")
    public Optional<Toy> getUserbyId(@PathVariable Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Toy not found");
        } else
            return toyRepository.findById(id);
    }

    @GetMapping("transaction/{id}")
    public Optional<Transaction> getTransactionbyId(@PathVariable Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Transaction not found");
        } else
            return transactionRepository.findById(id);
    }


    @GetMapping("/toys/{id}")
    public Optional<Toy> getToysById(@PathVariable Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Toy not found");
        } else
            return toyRepository.findById(id);
    }

    // POST / UPDATE
    @PostMapping("/toys")
    public String postToy(@ModelAttribute Toy toy) {
        toyRepository.save(toy);
        return "redirect:/toys";
    }

    @PostMapping("/users")
    public String postUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/toys";
    }

    @PostMapping("/transactions")
    public String postTransaction(@ModelAttribute Transaction transaction) {
        transactionRepository.save(transaction);
        return "redirect:/toys";
    }

    // DELETE
    @DeleteMapping("toys/{id}")
    public String deleteToy(@RequestParam Long id) {
        toyRepository.deleteById(id);
        return "redirect:/toys";
    }

    @DeleteMapping("transactions/{id}")
    public String deleteTransaction(@RequestParam Long id) {
        transactionRepository.deleteById(id);
        return "redirect:/transactions";
    }

    @DeleteMapping("users/{id}")
    public String deleteUsers(@RequestParam Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }


}
