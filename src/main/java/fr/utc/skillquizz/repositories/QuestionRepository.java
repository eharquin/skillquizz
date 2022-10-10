package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface QuestionRepository extends JpaRepository<Question, Long> {

    Optional<Question> deleteAnswerById(Long id);

    void deleteQuestionById(Long questionId);
}
