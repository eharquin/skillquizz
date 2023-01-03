package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Optional<Answer> deleteAnswerById(Long id);

    List<Answer> findAllByQuestionId(long questionId);

    @Query("select a from Course c join Answer a where c.id = :parcoursId")
    List<Answer> findAllByParcoursId(@Param("parcoursId")long parcoursId);
}
