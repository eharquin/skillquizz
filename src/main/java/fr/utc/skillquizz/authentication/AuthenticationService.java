package fr.utc.skillquizz.authentication;

import fr.utc.skillquizz.models.User;
import fr.utc.skillquizz.repositories.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.findUserByEmail(email).orElse(null);
        if (u == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + email);
        }
        if (!u.isActive()){
            throw new DisabledException("L'utilisateur est désactivé");
        }
        return createUser(u);
    }

    private org.springframework.security.core.userdetails.User createUser(User u) {
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), createAuthorities(u));
    }

    private Collection<GrantedAuthority> createAuthorities(User u) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + u.getType().toUpperCase()));
        return authorities;
    }
}
