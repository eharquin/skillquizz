package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.authentication.AuthenticationService;
import fr.utc.skillquizz.authentication.JwtRequestModel;
import fr.utc.skillquizz.authentication.JwtResponseModel;
import fr.utc.skillquizz.authentication.TokenManager;
import fr.utc.skillquizz.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private AuthenticationService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request, HttpServletResponse response) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            final String jwtToken = tokenManager.generateJwtToken(userDetails);
            Cookie cookie = new Cookie("jwt", jwtToken);
            response.addCookie(cookie);
            return ResponseEntity.ok(new JwtResponseModel(jwtToken));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
