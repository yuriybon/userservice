package ua.odessa.bondar.domain;


import javax.persistence.*;

@Entity
@Table(name="GENDER")
public class Gender {
    @Id
    @Column(name="GENDER_ID" ,unique = true ,nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long genderId;

    @Column(name = "GENDER_NAME", length = 50)
    private String genderName;

    public Gender(String genderName) {
        this.genderName = genderName;
    }


    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}
