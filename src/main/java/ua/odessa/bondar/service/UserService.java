package ua.odessa.bondar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.odessa.bondar.domain.User;
import ua.odessa.bondar.repo.UserRepo;
import ua.odessa.bondar.repo.UserRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public void createUser(String firstName, String lastName, Date birthDay , String gender) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDay(birthDay);
        user.setGender(gender);
        userRepo.save(user);
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }


    public void updateUser(Long UserId, String firstName, String lastName, Date birthDay , String gender) {
        Optional<User> userOptional = userRepo.findById(UserId);
        if (userOptional == null)
            return;
        User user = userOptional.get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDay(birthDay);
        user.setGender(gender);
        userRepo.save(user);
    }

}
