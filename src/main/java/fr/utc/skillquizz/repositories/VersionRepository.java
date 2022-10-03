package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface VersionRepository extends JpaRepository<Version, Long> {

    Optional<Version> deleteAnswerById(Long id);

}
