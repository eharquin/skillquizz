package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/question")
    public void index(){

    }

    @GetMapping("/question/{id}")
    public void show(@PathVariable int questionId){

    }

    @PostMapping("/question")
    public void store(@PathVariable int quizzId){

    }

    @PatchMapping("/question/{id}")
    public void update(@PathVariable int questionId){

    }

    @DeleteMapping("/question/{id}")
    public void destroy(@PathVariable int questionId){

    }
