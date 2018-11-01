package ua.odessa.bondar.domain;


import javax.persistence.*;

@Entity
@Table(name="GENDER")
public class Gender {
    @Id
    @Column(name="GENDER_ID" ,unique = true ,nullable = false, length = 4,updatable = false, insertable = false)
    private String genderId;

    @Column(name = "GENDER_NAME", length = 50)
    private String genderName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gender")
    private User user;



}
