package ua.odessa.bondar.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.odessa.bondar.domain.Address;
import ua.odessa.bondar.domain.User;
import ua.odessa.bondar.repo.UserRepository;
import ua.odessa.bondar.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.function.Consumer;


@RestController
public class RedirectController {

    Logger log = LoggerFactory.logger(RedirectController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/swagger")
    public void swagger(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/api/v1/userlist")
    public List<User> userList(HttpServletResponse resp) throws IOException {
        //Iterable<User> list = userService.getUsers();
        Iterable<User> list = userService.getUsers();
        list.forEach((t) -> System.out.println(t.getFirstName()));
        return (List<User>) list;
    }

    @GetMapping("/edit")
    public void editTable(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/EditTable.html");
    }


    @GetMapping("/view")
    public void viewTable(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/UserView.html");
    }

    @PostMapping("/api/v1/user/{userId}/delete")
    public void deleteUser(@PathVariable("userId") Long userId) throws IOException {
        userService.deleteUser(userId);
    }

    @PostMapping("/api/v1/user/create")
    public void createUser(@RequestParam String firstName
                         , @RequestParam String lastName
                         , @RequestParam Date birthDay
                         , @RequestParam String gender) throws IOException {
        log.info("Gender = "+gender);
        userService.createUser(firstName,lastName,birthDay,gender);
    }

    @PostMapping("/api/v1/user/update")
    public void createUser(@RequestParam Long userId
            , @RequestParam String firstName
            , @RequestParam String lastName
            , @RequestParam Date birthDay
            , @RequestParam Long gender) throws IOException {
        userService.updateUser(userId,firstName,lastName,birthDay,gender);
    }

    @GetMapping("/api/v1/user/history")
    public List<Address> getHistory() throws IOException {
        return userService.getAddress();
    }

}
