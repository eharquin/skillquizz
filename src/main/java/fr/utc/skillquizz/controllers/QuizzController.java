package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.repositories.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizzController {

    @Autowired
    private QuizzRepository quizzRepository;
}
