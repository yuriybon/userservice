package ua.odessa.bondar.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name =  "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private Date birthDay;

    @Column(name="GENDER")
    private String gender;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(birthDay, user.birthDay) &&
                Objects.equals(gender, user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, birthDay, gender);
    }
}
