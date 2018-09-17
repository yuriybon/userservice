package ua.odessa.bondar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.odessa.bondar.domain.User;
import ua.odessa.bondar.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

}
