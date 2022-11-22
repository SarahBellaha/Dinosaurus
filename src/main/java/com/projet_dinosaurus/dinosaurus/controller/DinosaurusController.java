package com.projet_dinosaurus.dinosaurus.controller;

import com.projet_dinosaurus.dinosaurus.entity.Toy;
import com.projet_dinosaurus.dinosaurus.repository.ToyRepository;
import com.projet_dinosaurus.dinosaurus.repository.TransactionRepository;
import com.projet_dinosaurus.dinosaurus.repository.UserRepository;

import org.springframework.data.domain.Sort;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DinosaurusController {
    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/toys")
    public List<Toy> getToys(@RequestParam(required = false) String sort) {
        List<Toy> toys = sort.isEmpty()? toyRepository.findAllToysAvailable() :
                toyRepository.findAllToysAvailableSorted(Sort.by(sort));
        return toys;
    }
}
