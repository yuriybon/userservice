package ua.odessa.bondar.service;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.odessa.bondar.domain.Address;
import ua.odessa.bondar.domain.Gender;
import ua.odessa.bondar.domain.User;
import ua.odessa.bondar.repo.GenderRepo;
import ua.odessa.bondar.repo.UserRepo;
import ua.odessa.bondar.repo.UserRepository;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    Logger log = LoggerFactory.logger(UserService.class);

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GenderRepo genderRepo;

//    @Autowired
//    private Address address;

    @Autowired
    public Iterable<User> getUsers() {
        //return userRepo.findAll();
        return userRepo.fetchUsers();
    }

    public void createUser(String firstName, String lastName, Date birthDay , String gender) {
           log.debug("gender = "+gender);
        User user = new User();
        Gender genderObj = new Gender(gender);
        genderRepo.save(genderObj);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDay(birthDay);
        user.setGender(genderObj);
        userRepo.save(user);
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }


    public void updateUser(Long UserId, String firstName, String lastName, Date birthDay , Long gender) {
        Optional<User> userOptional = userRepo.findById(UserId);
        log.debug(String.format( "Gender %n",gender));

        Optional<Gender> genderValue = genderRepo.findById(gender);
        if (userOptional == null)
            return;
        User user = userOptional.get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDay(birthDay);
        //genderValue.ifPresent(g -> user.setGender(g.getGenderName()));
        user.setGender(genderValue.get());
        userRepo.save(user);
    }


    public List<Address> getAddress() {
        return em.createNamedQuery("history_qvr").setParameter("p_country","UKRAINE").getResultList();
    }

}
