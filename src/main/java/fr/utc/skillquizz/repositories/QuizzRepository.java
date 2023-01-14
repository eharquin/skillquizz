package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Quizz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {
    Page<Quizz> searchBySkillContaining(String skill, Pageable pageable);

    @Query("SELECT AVG(c.score) FROM Course c where c.quizz.id = :quizzId")
    Integer getAvgScore(Long quizzId);

    @Query("SELECT MAX(c.score) FROM Course c where c.quizz.id = :quizzId")
    Integer getBestScore(Long quizzId);

    @Query("SELECT Min(c.score) FROM Course c where c.quizz.id = :quizzId")
    Integer getWorstScore(Long quizzId);

    Page<Quizz> findAll(Pageable pageable);
}
