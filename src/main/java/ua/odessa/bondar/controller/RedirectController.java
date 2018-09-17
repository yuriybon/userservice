package ua.odessa.bondar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.odessa.bondar.domain.User;
import ua.odessa.bondar.repo.UserRepository;
import ua.odessa.bondar.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;


@RestController
public class RedirectController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //@ApiIgnore
    @GetMapping("/swagger")
    public void swagger(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/api/v1/userlist")
    public List<User> userList(HttpServletResponse resp) throws IOException {
        Iterable<User> list = userService.getUsers();
        list.forEach((t) -> System.out.println(t.getFirstName()));
        return (List<User>) list;
        //resp.sendRedirect("/UserView.html");
    }

    @GetMapping("/api/v1/userRepList")
    public List<User> userRepList(HttpServletResponse resp) throws IOException {
        List<User> list = userRepository.findAll();
        list.forEach((t) -> System.out.println(t.getFirstName()));
        return list;
        //resp.sendRedirect("/UserView.html");
    }

    @GetMapping("/edit")
    public void editTable(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/EditTable.html");
    }


    @GetMapping("/view")
    public void viewTable(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/UserView.html");
    }
}
