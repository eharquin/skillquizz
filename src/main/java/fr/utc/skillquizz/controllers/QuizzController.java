package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.dto.QuizzDto;
import fr.utc.skillquizz.services.QuizzService;
import fr.utc.skillquizz.models.Quizz;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuizzController extends BaseController{

    private QuizzService quizzService;



    @GetMapping("/quizz")
    public List<QuizzDto> index(){
        List<Quizz> quizzes = quizzService.getQuizzesList();
        List<QuizzDto> quizzesDto = super.mapList(quizzes, QuizzDto.class);
        return quizzesDto;
    }

    @GetMapping("/quizz/{id}")
    public QuizzDto show(@PathVariable int quizzId){
        Quizz quizz = quizzService.getQuizz(quizzId);
        QuizzDto quizzDto = convertToDto(quizz);
        return quizzDto;
    }

    @PostMapping("/admin/quizz")
    public void store(@RequestBody QuizzDto quizzDto){
        Quizz quizz = convertToEntity(quizzDto);
        // convertir QuizzDto en Quizz
        Quizz newQuizz = quizzService.createQuizz(quizz);
        /*if (recordCreated)
            return new ResponseEntity(HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
         */
    }

    @PatchMapping("/admin/quizz/{id}")
    public void update(@PathVariable long quizzToModifyId, @RequestBody Quizz quizz){
        Quizz newQuizz = quizzService.updateQuizz(quizzToModifyId, quizz);
    }

    @DeleteMapping("/admin/quizz/{id}")
    public void destroy(@PathVariable long quizzId){
       quizzService.deleteQuizz(quizzId);
    }

    private QuizzDto convertToDto(Quizz quizz) {
        QuizzDto quizzDto = super.getModelMapper().map(quizz, QuizzDto.class);
        return quizzDto;
    }

    private Quizz convertToEntity(QuizzDto quizzDto) {
        Quizz quizz = super.getModelMapper().map(quizzDto, Quizz.class);
        return quizz;
    }

}
