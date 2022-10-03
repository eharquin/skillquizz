package fr.utc.skillquizz.repositories;

import fr.utc.skillquizz.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
