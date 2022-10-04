package fr.utc.skillquizz.controllers;


import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.services.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {

    private AnswerService answerService;

    @GetMapping("/answer")
    public void index(){

    }

    @GetMapping("/answer/{id}")
    public void show(@PathVariable int answerId){

    }

    @PostMapping("/answer")
    public void store(@RequestBody Answer answer){
        answerService.createAnswer(answer);
        /*if (recordCreated)
            return new ResponseEntity(HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
         */
    }

    @PatchMapping("/answer/{id}")
    public void update(@PathVariable long answerToModifyId, @RequestBody Answer answer){
        answerService.updateAnswer(answer, answerToModifyId);
    }

    @DeleteMapping("/answer/{id}")
    public void destroy(@PathVariable long answerId){
        answerService.deleteAnswer(answerId);
    }
}
