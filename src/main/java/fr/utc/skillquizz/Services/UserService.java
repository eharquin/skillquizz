package fr.utc.skillquizz.services;

import fr.utc.skillquizz.models.User;
import fr.utc.skillquizz.repositories.AnswerRepository;
import fr.utc.skillquizz.repositories.CourseRepository;
import fr.utc.skillquizz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public void update(long courseToModifyId, User user) {
        User old = getUser(courseToModifyId);
        old.setCompany(user.getCompany());
        old.setEmail(old.getEmail());
        old.setName(user.getName());
        old.setPhoneNumber(user.getPhoneNumber());
        old.setType(user.getType());
        userRepository.save(old);
    }

    public void delete(long userId) {
        userRepository.deleteById(userId);
    }
}
