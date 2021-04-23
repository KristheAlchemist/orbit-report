package org.javaportfolio.quizapp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Admin extends AbstractUser {

    @Id
    @GeneratedValue
    private int AdminId;

    public Admin() {};

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }
}
