package org.javaportfolio.quizapp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Student extends AbstractUser {

    @Id
    @GeneratedValue
    private int studentId;

    public Student() {};

    public int getStudentId() {
        return studentId;
    }

}
