package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/quizz")
    public void index(){

    }

    @GetMapping("/quizz/{id}")
    public void show(@PathVariable int quizzId){

    }

    @PostMapping("/quizz")
    public void store(){

    }

    @PatchMapping("/quizz/{id}")
    public void update(@PathVariable int quizzId){

    }

    @DeleteMapping("/quizz/{id}")
    public void detroy(@PathVariable int quizzId){

    }
}
