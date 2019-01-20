package ua.odessa.bondar.repo;

import org.springframework.data.repository.CrudRepository;
import ua.odessa.bondar.domain.Address;

public interface AddressRepo extends CrudRepository<Address,String> {



}
