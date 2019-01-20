package ua.odessa.bondar.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.odessa.bondar.domain.User;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

// @Query("select u.user_id,u.birth_date, u.first_name, u.last_name, g.gender_name as gender from users u join gender g on (u.gender_id = g.gender_id)")
    @Query(value = "select u.user_id,u.birth_date, u.first_name, u.last_name, u.gender_id from users u ", nativeQuery = true)
    List<User> fetchUsers();

}
