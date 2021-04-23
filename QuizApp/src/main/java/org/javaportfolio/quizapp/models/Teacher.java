package org.javaportfolio.quizapp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Teacher extends AbstractUser {

    @Id
    @GeneratedValue
    private int teacherId;

    public Teacher() {};

    public int getTeacherId() {
        return teacherId;
    }
}
