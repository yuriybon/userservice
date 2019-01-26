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
' this is comment
!define SEQUENCE (S,#AAAAAA) Database Sequence
!define TABLE (T,#FFFF00) Database Table
!define Table(name,desc) class name as "desc" << (T,#FFAAAA) >>
!define primary_key(x) <b>x</b>
!define unique(x) <color:green>x</color>
!define not_null(x) <u>x</u>

class USER_DATA << TABLE >>
class USER_PROFILES << TABLE >>
class SEQ_USER_DATA << SEQUENCE >>
USER_DATA "1" -- "1" USER_PROFILES
SEQ_USER_DATA -> USER_DATA

hide methods
hide stereotypes

' entities

Table(user, "user\n(User in our system)") {
primary_key(id) INTEGER
not_null(unique(username)) VARCHAR[32]
not_null(password) VARCHAR[64]
}

Table(session, "session\n(session for user)") {
primary_key(id) INTEGER
not_null(user_id) INTEGER
not_null(unique(session_id) VARCHAR[64]
}

Table(user_profile, "user_profile\n(Some info of user)") {
primary_key(user_id) INTEGER
age SMALLINT
gender SMALLINT
birthday DATETIME
}

Table(group, "group\n(group of users)") {
primary_key(id) INTEGER
not_null(name) VARCHAR[32]
}


Table(user_group, "user_group\n(relationship of user and group)") {
primary_key(user_id) INTEGER
primary_key(group_id) INTEGER
joined_at DATETIME
}


' relationships
' one-to-one relationship
user -- user_profile : "A user only \nhas one profile"
' one to may relationship
user --> session : "A user may have\n many sessions"
' many to many relationship
' Add mark if you like
user "1" --> "*" user_group : "A user may be \nin many groups"
group "1" --> "0..N" user_group : "A group may \ncontain many users"

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
