package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.Services.AnswerServices;
import fr.utc.skillquizz.Services.QuizzService;
import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.models.Quizz;
import fr.utc.skillquizz.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {

    private AnswerServices answerService;

    @GetMapping("/answer")
    public void index(){

    }

    @GetMapping("/answer/{id}")
    public void show(@PathVariable int answerId){

    }

    @PostMapping("/answer")
    public void store(@RequestBody Answer answer){
        Answer answer = answerService.createAnswer(answer);
        /*if (recordCreated)
            return new ResponseEntity(HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
         */
    }

    @PatchMapping("/answer/{id}")
    public void update(@PathVariable long answerToModifyId, @RequestBody Answer answer){
        Answer updatedAnswer = answerService.updateAnswer(answerToModifyId, answer);
    }

    @DeleteMapping("/answer/{id}")
    public void destroy(@PathVariable long answerId){
        answerService.deleteAnswer(answerId);
    }
}
