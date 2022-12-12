package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long> {

    Optional<Version> deleteAnswerById(Long id);

}
