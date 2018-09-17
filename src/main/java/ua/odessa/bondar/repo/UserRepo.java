package ua.odessa.bondar.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.odessa.bondar.domain.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
