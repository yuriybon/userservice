package ua.odessa.bondar.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.odessa.bondar.domain.UserProfile;

@Repository
public interface UserProfileRepo extends CrudRepository<UserProfile, Long> {
}
