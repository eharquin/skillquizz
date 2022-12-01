package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.dto.UserDto;
import fr.utc.skillquizz.models.User;
import fr.utc.skillquizz.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController extends BaseController{

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/register", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setCompany(userDto.getCompany());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);

        return new ResponseEntity<>(getModelMapper().map(user, UserDto.class), HttpStatus.OK);
    }
}
