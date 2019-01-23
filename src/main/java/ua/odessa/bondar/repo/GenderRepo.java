package ua.odessa.bondar.repo;

import org.springframework.data.repository.CrudRepository;
import ua.odessa.bondar.domain.Gender;

import java.util.Optional;

public interface GenderRepo extends CrudRepository<Gender,Long> {
}
