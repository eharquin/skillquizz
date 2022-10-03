package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzRepository extends JpaRepository<Quizz, Long> {
}
