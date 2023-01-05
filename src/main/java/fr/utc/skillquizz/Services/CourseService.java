package fr.utc.skillquizz.services;

import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.models.Course;
import fr.utc.skillquizz.repositories.AnswerRepository;
import fr.utc.skillquizz.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final AnswerRepository answerRepository;

    public CourseService(CourseRepository courseRepository, AnswerRepository answerRepository) {

        this.courseRepository = courseRepository;
        this.answerRepository = answerRepository;
    }
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getCoursesFor(long userId) {
        return courseRepository.findByUserId(userId);
    }

    public Course getCourse(long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course, long courseToModifyId) {
        Course courseOld = courseRepository.getById(courseToModifyId);
        courseOld.setDuration(course.getDuration());
        courseOld.setScore(course.getScore());
        courseRepository.save(courseOld);
    }

    public void deleteCourse(long courseId) {
        courseRepository.deleteById(courseId);
    }

    public void addAnswerToCourse(long idAnswer, long idCourse) {
        Answer answer= answerRepository.findById(idAnswer).orElseThrow();
        Course course = courseRepository.findById(idCourse).orElseThrow();
        course.getAnswers().add(answer);
        courseRepository.save(course);
    }

}
