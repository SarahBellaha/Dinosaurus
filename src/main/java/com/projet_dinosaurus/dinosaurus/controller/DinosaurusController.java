package com.projet_dinosaurus.dinosaurus.controller;

import com.projet_dinosaurus.dinosaurus.entity.Toy;
import com.projet_dinosaurus.dinosaurus.entity.User;
import com.projet_dinosaurus.dinosaurus.repository.ToyRepository;
import com.projet_dinosaurus.dinosaurus.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DinosaurusController {
    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/toys")
    public List<Toy> getToys() {
        return toyRepository.findAll();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/toys")
    public String addToy(@RequestBody Toy toy) {
        User user = userRepository.findById(toy.userId).orElse(null);
        toy.setUser(user);
        toyRepository.save(toy);
        System.out.println(toy.getUser().getFirstName());
        System.out.println(toy.getUser().getLastName());
        return "Post Toy OK!";
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "Post User OK !";
    }

}
