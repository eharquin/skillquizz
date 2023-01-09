package fr.utc.skillquizz.authentication;

import fr.utc.skillquizz.models.User;
import fr.utc.skillquizz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    @Autowired
    private UserRepository userRepository;

    public User getUser() {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByEmail(details.getUsername()).orElseThrow();
    }
}
