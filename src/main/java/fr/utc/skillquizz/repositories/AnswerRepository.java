package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Optional<Answer> deleteAnswerById(Long id);

}
