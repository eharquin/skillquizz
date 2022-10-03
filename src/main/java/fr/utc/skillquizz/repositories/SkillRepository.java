package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> deleteAnswerById(Long id);

}
