package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.models.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {

}
