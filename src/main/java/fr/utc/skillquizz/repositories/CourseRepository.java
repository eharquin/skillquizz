package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Course;
import fr.utc.skillquizz.models.Quizz;
import fr.utc.skillquizz.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByUserId(Long userId);
    List<Course> findAllByQuizzIdOrderByScoreDesc(Long quizzId);

}
