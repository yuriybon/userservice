package ua.odessa.bondar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.odessa.bondar.domain.Gender;
import ua.odessa.bondar.domain.User;
import ua.odessa.bondar.domain.UserProfile;
import ua.odessa.bondar.repo.UserProfileRepo;
import ua.odessa.bondar.repo.UserRepo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
@startuml
!define SEQUENCE (S,#AAAAAA) Database Sequence
!define TABLE (T,#FFFF00) Database Table

class USER_DATA << TABLE >>
class USER_PROFILES << TABLE >>
class UID << SEQUENCE >>
USER_DATA "1" -- "1" USER_PROFILES
UID -> USER_DATA
@enduml
*/
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public void createUser(String firstName
                        , String lastName
                        , String email
                        , String password
                        , String phoneNumber
                        , String gender
                        , Date birthDay
                        , String address1
                        , String address2
                        , String street
                        , String city
                        , String state
                        , String country
                        , String zipCode) {

        // Create a User instance
        User user = new User(firstName, lastName, email,password);

        // Create a UserProfile instance
        UserProfile userProfile = new UserProfile(phoneNumber, Gender.valueOf(gender), birthDay,address1, address2, street, city, state, country, zipCode);


        // Set child reference(userProfile) in parent entity(user)
        user.setUserProfile(userProfile);

        // Set parent reference(user) in child entity(userProfile)
        userProfile.setUser(user);

        userRepo.save(user);
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }


//    public void updateUser(Long UserId, String firstName, String lastName, Date birthDay , Long gender) {
//        Optional<User> userOptional = userRepo.findById(UserId);
//        Optional<Gender> genderValue = genderRepo.findById(gender);
//        if (userOptional == null)
//            return;
//        User user = userOptional.get();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setBirthDay(birthDay);
//        user.setGender(genderValue.get());
//        userRepo.save(user);
//    }

    public List<User> getListUsers() {
        Iterable<User> usersIter = getUsers();
        List<User> users = new ArrayList<>();
        for (User user : usersIter) {
            users.add(user);
        }
        return users;
    }
}
