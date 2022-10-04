package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.Services.QuizzService;
import fr.utc.skillquizz.models.Quizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizzController {

    private QuizzService quizzService;

    @GetMapping("/quizz")
    public void index(){

    }

    @GetMapping("/quizz/{id}")
    public void show(@PathVariable int quizzId){
        quizzService.getQuizz(quizzId);
    }

    @PostMapping("/quizz")
    public void store(@RequestBody Quizz quizz){
        Quizz newQuizz = quizzService.createQuizz(quizz);
        /*if (recordCreated)
            return new ResponseEntity(HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
         */
    }

    @PatchMapping("/quizz/{id}")
    public void update(@PathVariable long quizzToModifyId, @RequestBody Quizz quizz){
        Quizz newQuizz = quizzService.updateQuizz(quizzToModifyId, quizz);
    }

    @DeleteMapping("/quizz/{id}")
    public void destroy(@PathVariable long quizzId){
       quizzService.deleteQuizz(quizzId);
    }
}
