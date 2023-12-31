package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.authentication.AuthenticationFacade;
import fr.utc.skillquizz.dto.CourseDto;
import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.models.Course;
import fr.utc.skillquizz.models.Question;
import fr.utc.skillquizz.services.AnswerService;
import fr.utc.skillquizz.services.CourseService;
import fr.utc.skillquizz.services.QuizzService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class CourseController extends BaseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private QuizzService quizzService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private AuthenticationFacade auth;

    @GetMapping(path = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDto> index() {
        List<Course> coursesList = courseService.getCoursesFor(auth.getUser().getId());
        List<CourseDto> coursesDtoList = mapList(coursesList, CourseDto.class);
        return coursesDtoList;
    }

    @GetMapping(path = "/course/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseDto show(@PathVariable long id) {
        Course course = courseService.getCourse(id);
        CourseDto courseDto = convertToDto(course);
        return courseDto;
    }

    @PostMapping("/course")
    public void store(@RequestBody CourseDto courseDto) {
        Course course = convertToEntity(courseDto);
        if (courseDto.getStartDate() != null) {
            Timestamp endTime = new Timestamp(System.currentTimeMillis());
            int duration = (int) (endTime.getTime() - courseDto.getStartDate().getTime());
            course.setDuration(duration);
        }
        course.setUser(auth.getUser());
        course.setScore(0);
        for (Answer answer : course.getAnswers()) {
            Answer trueAnswer = answerService.getAnswer(answer.getId());
            if (Objects.equals(answer.getId(), trueAnswer.getQuestion().getGoodAnswer().getId())) {
                course.setScore(course.getScore() + 1);
            }
        }
        courseService.createCourse(course);
    }

    @DeleteMapping("/course/{courseId}")
    public void destroy(@PathVariable long courseId) {
        courseService.deleteCourse(courseId);
    }

    private CourseDto convertToDto(Course course) {
        CourseDto courseDto = getModelMapper().map(course, CourseDto.class);
        return courseDto;
    }

    private Course convertToEntity(CourseDto courseDto) {
        Course course = getModelMapper().map(courseDto, Course.class);
        return course;
    }
}
