package ua.odessa.bondar.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name =  "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private Date birthDay;

    @Column(name = "GENDER_ID" )
    @JoinColumn(table = "GENDER", referencedColumnName = "GENDER_ID", columnDefinition = "GENDER_NAME", foreignKey =  @ForeignKey(name = "FK_USER_GENDER",value=ConstraintMode.NO_CONSTRAINT) , updatable = false, insertable = false)
    private Long genderId;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    public Gender gender;

//    @JoinColumn(table = "GENDER", referencedColumnName = "GENDER_ID", foreignKey =  @ForeignKey(name = "FK_USER_GENDER",value=ConstraintMode.NO_CONSTRAINT) , updatable = false, insertable = false)
//    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
//    private Gender gender;


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
        //return birthDay.isPresent() ? new Date(birthDay.get().getTime()) : null;
        return Optional
                .ofNullable(birthDay)
                .map(Date::getTime)
                .map(Date::new)
                .orElse(null);
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay =     Optional

                .ofNullable(birthDay)
                .map(Date::getTime)
                .map(Date::new)
                .orElse(null);
    }
//
//    public String getGender() {
//        return gender.getGenderName();
//    }
//
    public Long getGenderId() {
        return genderId;
    }

    public void setGender(Gender gender) {
        this.genderId = gender.getGenderId();
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
                Objects.equals(birthDay, user.birthDay) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, birthDay);
    }
}
