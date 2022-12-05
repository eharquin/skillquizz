package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.dto.CourseDto;
import fr.utc.skillquizz.dto.QuestionDto;
import fr.utc.skillquizz.models.Course;
import fr.utc.skillquizz.models.Question;
import fr.utc.skillquizz.repositories.QuestionRepository;
import fr.utc.skillquizz.services.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuestionController extends BaseController{

    @Autowired
    private QuestionService questionService;

    
    @GetMapping("/question")
    public List<QuestionDto> index() {
        List<Question> questions = questionService.getList();
        return mapList(questions, QuestionDto.class);
    }

    @GetMapping("/question/{questionId}")
    public QuestionDto show(@PathVariable long questionId) {
        Question question = questionService.getById(questionId);
        return convertToDto(question);
    }

    @PostMapping("/admin/question")
    public void store(@RequestBody Question question) {
        questionService.createQuestion(question);
    }

    @PatchMapping("/admin/question/{questionId}")
    public void update(@PathVariable long questionId, @RequestBody Question question) {
        questionService.updateQuestion(question, questionId);
    }

    @DeleteMapping("/admin/question/{questionId}")
    public void destroy(@PathVariable long questionId) {
        questionService.deleteQuestion(questionId);
    }

    private QuestionDto convertToDto(Question question) {
        QuestionDto questionDto = getModelMapper().map(question, QuestionDto.class);
        return questionDto;
    }

    private Question convertToEntity(QuestionDto questionDto)  {
        Question question = getModelMapper().map(questionDto, Question.class);
        return question;
    }
}
