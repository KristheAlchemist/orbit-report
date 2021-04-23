package org.javaportfolio.quizapp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class AbstractUser {

    @NotNull(message="First name is required.")
    @NotBlank(message="First name is required.")
    @Size(max=22, message="First name is too long")
    private String firstName;

    @NotNull(message="Last name is required.")
    @NotBlank(message="Last name is required.")
    @Size(max=22, message="Last name is too long")
    private String lastName;

    @NotNull(message="Username is required.")
    @NotBlank(message="Username is required.")
    @Size(max=22, message="Username is too long")
    private String userName;

    @NotNull(message="At least one course is required.")
    @NotBlank(message="At least one course is required.")
    @Size(max=22, message="Course name is too long")
    private List<String> courses = new ArrayList<>();

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
