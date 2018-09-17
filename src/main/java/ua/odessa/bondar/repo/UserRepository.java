package ua.odessa.bondar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.odessa.bondar.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
