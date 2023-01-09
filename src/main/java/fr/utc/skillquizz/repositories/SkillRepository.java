package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> deleteAnswerById(Long id);

}
