package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.dto.CourseDto;
import fr.utc.skillquizz.models.Course;
import fr.utc.skillquizz.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(path = "/course", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDto> index(){
        List<Course> coursesList = courseService.getCourses();
        List<CourseDto> coursesDtoList = mapList(coursesList, CourseDto.class);
        return coursesDtoList;
    }


    @GetMapping(path = "/course/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public CourseDto show(@PathVariable long id){
        Course course =  courseService.getCourse(id);
        CourseDto courseDto = convertToDto(course);
        return courseDto;
    }

    @PostMapping("/course")
    public void store(@RequestBody CourseDto courseDto){
        Course course = convertToEntity(courseDto);
        courseService.createCourse(course);
    }

    @PatchMapping("/course/{courseToModifyId}")
    public void update(@PathVariable long courseToModifyId, @RequestBody CourseDto courseDto){
        Course course = convertToEntity(courseDto);
        courseService.updateCourse(course, courseToModifyId);
    }

    @PostMapping("/course/{courseToModifyId}/answer/{answerToAdd}")
    public void addAnswerToCourse(@PathVariable long courseToModifyId, @PathVariable long answerToAdd){
        courseService.addAnswerToCourse(courseToModifyId, answerToAdd);
    }

    @DeleteMapping("/course/{courseId}")
    public void destroy(@PathVariable long courseId){
        courseService.deleteCourse(courseId);
    }

    private CourseDto convertToDto(Course course) {
        CourseDto courseDto = modelMapper.map(course, CourseDto.class);
        return courseDto;
    }

    private Course convertToEntity(CourseDto courseDto)  {
        Course course = modelMapper.map(courseDto, Course.class);

        return course;
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
