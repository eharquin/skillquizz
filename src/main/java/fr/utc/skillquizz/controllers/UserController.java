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

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> index() {
        List<User> users = userService.getUsers();
        List<UserDto> usersDto = mapList(users, UserDto.class);
        return usersDto;
    }

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto show(@PathVariable Long id) {
        User user = userService.getUser(id);
        return convertToDto(user);
    }

    @PostMapping("/user")
    public void store(@RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        userService.create(user);
    }

    @PatchMapping("/user/{id}")
    public void update(@PathVariable long id, @RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        userService.update(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void destroy(@PathVariable long id) {
        userService.delete(id);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = getModelMapper().map(user, UserDto.class);

        return userDto;
    }

    private User convertToEntity(UserDto userDto) {
        User user = getModelMapper().map(userDto, User.class);

        return user;
    }

}
