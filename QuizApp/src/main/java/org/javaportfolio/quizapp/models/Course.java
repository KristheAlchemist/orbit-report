package org.javaportfolio.quizapp.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Course {

    @NotNull(message="Course name is required.")
    @NotBlank(message="Course name is required.")
    @Size(max=22, message="Course name is too long")
    private String name;

    @NotNull(message="Description is required.")
    @NotBlank(message="Description is required.")
    @Size(max=22, message="Description is too long")
    private String description;

//    @ManyToMany
    List<Student> students = new ArrayList<>();

    //    @ManyToMany
    List<Teacher> teachers = new ArrayList<>();
}
