package ua.odessa.bondar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ua.odessa.bondar.domain.User;
import ua.odessa.bondar.service.UserService;

@RestController
public class WebApiController {

    @Autowired
    private UserService userService;

    public Iterable<User> getUsers(){
        return userService.getUsers();
    }
//    @GetMapping("/api/trial")
//    public Iterable<Trial> getTrials() {
//        return trialService.getTrials();
//    }

}
