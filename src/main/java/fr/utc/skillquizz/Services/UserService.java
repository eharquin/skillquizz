package fr.utc.skillquizz.services;

import fr.utc.skillquizz.repositories.AnswerRepository;
import fr.utc.skillquizz.repositories.CourseRepository;
import fr.utc.skillquizz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }
}
