package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.models.Question;
import fr.utc.skillquizz.repositories.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/question")
    public void index() {

    }

    @GetMapping("/question/{id}")
    public void show(@PathVariable int questionId) {

    }

    @PostMapping("/admin/question")
    public void store(@RequestBody Question question) {

    }

    @PatchMapping("/admin/question/{id}")
    public void update(@PathVariable int questionId, @RequestBody Question question) {

    }

    @DeleteMapping("/admin/question/{id}")
    public void destroy(@PathVariable int questionId) {

    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
