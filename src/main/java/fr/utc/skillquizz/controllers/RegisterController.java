package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;


}
