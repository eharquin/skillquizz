package fr.utc.skillquizz.controllers;


import fr.utc.skillquizz.dto.AnswerDto;
import fr.utc.skillquizz.dto.UserDto;
import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.services.AnswerService;
import org.apache.tomcat.util.json.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnswerController extends BaseController{
    @Autowired
    private AnswerService answerService;

    @GetMapping(path = "/answer", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<AnswerDto> index(){
        List<Answer> answerList = answerService.getAnswers();
        List<AnswerDto> answerDtoList = mapList(answerList, AnswerDto.class);
        return answerDtoList;
    }

    @GetMapping(path = "quizz/{quizzId}/question/{questionId}/answer", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<AnswerDto> getAnswersByQuestionId(@PathVariable long quizzId, @PathVariable long questionId){
        List<Answer> answerList = answerService.getAnswersByQuestionId(questionId);
        List<AnswerDto> answerDtoList = mapList(answerList, AnswerDto.class);
        return answerDtoList;
    }

    @GetMapping(path = "parcours/{parcoursId}/answer", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<AnswerDto> getAnswersByIdParcours(@PathVariable long parcoursId){
        List<Answer> answerList = answerService.getAnswersByParcoursId(parcoursId);
        List<AnswerDto> answerDtoList = mapList(answerList, AnswerDto.class);
        return answerDtoList;
    }

    @GetMapping(path = "/answer/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public AnswerDto show(@PathVariable long id){
        Answer answer =  answerService.getAnswer(id);
        AnswerDto answerDto = convertToDto(answer);
        return answerDto;
    }

    @PostMapping("/answer")
    public void store(@RequestBody AnswerDto answerDto){
        Answer answer = convertToEntity(answerDto);
        answerService.createAnswer(answer);
    }

    @PatchMapping("/answer/{id}")
    public void update(@PathVariable long answerToModifyId, @RequestBody AnswerDto answerDto){
        Answer answer = convertToEntity(answerDto);
        answerService.updateAnswer(answer, answerToModifyId);
    }

    @DeleteMapping("/answer/{answerId}")
    public void destroy(@PathVariable long answerId){
        answerService.deleteAnswer(answerId);
    }

    private AnswerDto convertToDto(Answer answer) {
        AnswerDto answerDto = getModelMapper().map(answer, AnswerDto.class);
        return answerDto;
    }

    private Answer convertToEntity(AnswerDto answerDto)  {
        Answer answer = getModelMapper().map(answerDto, Answer.class);

        if (answerDto != null) {
            Answer answerOld =  answerService.getAnswer((long) answerDto.getId());
            answer.setId(answerOld.getId());
        }
        return answer;
    }

}
