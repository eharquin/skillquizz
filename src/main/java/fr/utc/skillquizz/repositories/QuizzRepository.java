package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Quizz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {
    Page<Quizz> searchBySkillContaining(String skill, Pageable pageable);

    Page<Quizz> findAll(Pageable pageable);
}
