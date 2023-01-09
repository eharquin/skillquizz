package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.dto.QuizzDto;
import fr.utc.skillquizz.services.CourseService;
import fr.utc.skillquizz.services.QuizzService;
import fr.utc.skillquizz.models.Quizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizzController extends BaseController {

    @Autowired
    private QuizzService quizzService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/quizz")
    public List<QuizzDto> index() {
        List<Quizz> quizzes = quizzService.getQuizzesList();
        List<QuizzDto> quizzesDto = super.mapList(quizzes, QuizzDto.class);
        return quizzesDto;
    }

    @GetMapping("/quizz/{id}")
    public QuizzDto show(@PathVariable Long id) {
        Quizz quizz = quizzService.getQuizz(id);
        QuizzDto dto = convertToDto(quizz);
        dto.setAvgScore(courseService.getAvgScore(id));
        dto.setBestScore(courseService.getBestScore(id));
        dto.setWorstScore(courseService.getWorstScore(id));
        return dto;
    }

    @PostMapping("/admin/quizz")
    public void store(@RequestBody QuizzDto quizzDto) {
        Quizz quizz = convertToEntity(quizzDto);
        Quizz newQuizz = quizzService.createQuizz(quizz);
    }

    @PatchMapping("/admin/quizz/{id}")
    public void update(@PathVariable long id, @RequestBody Quizz quizz) {
        Quizz newQuizz = quizzService.updateQuizz(id, quizz);
    }

    @DeleteMapping("/admin/quizz/{id}")
    public void destroy(@PathVariable long id) {
        quizzService.deleteQuizz(id);
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
