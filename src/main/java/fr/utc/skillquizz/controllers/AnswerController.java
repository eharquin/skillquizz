package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/answer")
    public void index(){

    }

    @GetMapping("/answer/{id}")
    public void show(@PathVariable int answerId){

    }

    @PostMapping("/answer")
    public void store(){

    }

    @PatchMapping("/answer/{id}")
    public void update(@PathVariable int answerId){

    }

    @DeleteMapping("/answer/{id}")
    public void destroy(@PathVariable int answerId){

    }
}
