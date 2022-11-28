package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.dto.CourseDto;
import fr.utc.skillquizz.dto.UserDto;
import fr.utc.skillquizz.models.Course;
import fr.utc.skillquizz.models.User;
import fr.utc.skillquizz.services.AnswerService;
import fr.utc.skillquizz.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;


    @GetMapping(path = "/user", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> index(){

    }


    @GetMapping(path = "/user/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public UserDto show(@PathVariable long id){

    }

    @PostMapping("/user")
    public void store(@RequestBody UserDto courseDto){

    }

    @PatchMapping("/user/{id}")
    public void update(@PathVariable long courseToModifyId, @RequestBody UserDto courseDto){

    }

    @DeleteMapping("/user/{userId}")
    public void destroy(@PathVariable long userId){

    }

    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    private User convertToEntity(UserDto userDto)  {
        User user = modelMapper.map(userDto, User.class);

        return user;
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
