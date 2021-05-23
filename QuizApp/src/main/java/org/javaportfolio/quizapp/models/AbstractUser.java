package org.javaportfolio.quizapp.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.*;

@MappedSuperclass
public abstract class AbstractUser {

    @Id
    @GeneratedValue
    private int userId;

    @NotNull
    protected String firstName;

    @NotNull
    protected String lastName;

    @NotNull
    protected String email;

    @NotNull
    protected String pwHash;

    protected static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//    @NotNull(message="At least one course is required.")
//    @NotBlank(message="At least one course is required.")
//    @Size(max=22, message="Course name is too long")
//    private List<String> courses = new ArrayList<>();

    public int getUserId() {
        return userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<String> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<String> courses) {
//        this.courses = courses;
//    }

}
