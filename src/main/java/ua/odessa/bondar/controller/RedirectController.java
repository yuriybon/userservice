package ua.odessa.bondar.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.odessa.bondar.domain.User;
import ua.odessa.bondar.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
public class RedirectController {

    @Autowired
    private UserService userService;

    @GetMapping("/swagger")
    public void swagger(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/api/v2/userlist")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Applicants not found")
    })
    public ResponseEntity<List<User>> userEntityList(HttpServletResponse resp) throws IOException, NotFoundException {
        List<User> users = userService.getListUsers();

        if (!users.isEmpty()) {
            return ResponseEntity.ok().body(users);
        }else{
            throw new NotFoundException("users not found");
        }

//        //ResponseEntity.ok(List<User>())
//        responseEntity.
////        Iterable<User> list = userService.getUsers();
////        list.forEach((t) -> System.out.println(t.getFirstName()));
//        return responseEntity;
    }


    @GetMapping("/api/v1/userlist")
    public List<User> userList(HttpServletResponse resp) throws IOException {
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
    public void createUser(
              @RequestParam(required = false) Optional<String> firstName
            , @RequestParam (required = false ) Optional<String> lastName
            , @RequestParam (required = false ) Optional<String> email
            , @RequestParam (required = false ) Optional<String> password
            , @RequestParam (required = false ) Optional<String> phoneNumber
            , @RequestParam (required = false ) Optional<String> gender
            , @RequestParam (required = false ) Optional<Date> birthDay
            , @RequestParam (required = false ) Optional<String> address1
            , @RequestParam (required = false ) Optional<String> address2
            , @RequestParam (required = false ) Optional<String> street
            , @RequestParam (required = false ) Optional<String> city
            , @RequestParam (required = false ) Optional<String> state
            , @RequestParam (required = false ) Optional<String> country
            , @RequestParam (required = false ) Optional<String> zipCode
    ) throws IOException {
        userService.createUser(
                firstName.get()
                , lastName.get()
                , email.get()
                , password.get()
                , phoneNumber.get()
                , gender.get()
                , birthDay.get()
                , address1.get()
                , address2.get()
                , street.get()
                , city.get()
                , state.get()
                , country.get()
                , zipCode.get()
        );
    }

//    @PostMapping("/api/v1/user/update")
//    public void createUser(@RequestParam Long userId
//            , @RequestParam String firstName
//            , @RequestParam String lastName
//            , @RequestParam Date birthDay
//            , @RequestParam Long gender) throws IOException {
//        userService.updateUser(userId,firstName,lastName,birthDay,gender);
//    }
}
