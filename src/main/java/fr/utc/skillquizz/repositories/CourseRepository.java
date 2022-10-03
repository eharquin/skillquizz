package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> deleteAnswerById(Long id);

}
