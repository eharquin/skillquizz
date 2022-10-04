package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.models.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizzRepository extends JpaRepository<Quizz, Long> {

    Optional<Answer> deleteQuizzById(Long id);
}
