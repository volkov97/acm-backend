package com.owuteam.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.owuteam.core.BaseEntity;
import com.owuteam.news.News;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_users")
public class User extends BaseEntity {

    @NotNull
    @Size(min = 1, max = 80)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 80)
    private String secondName;

    @NotNull
    @Size(min = 1, max = 80)
    private String fatherName;

    @NotNull
    @Column(unique = true)
    @Size(min = 1, max = 80)
    private String userName;

    @NotNull
    private String password;

    public User() {
        super();
    }

    public User(String firstName, String secondName, String fatherName, String userName, String password, String[] roles) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.fatherName = fatherName;
        this.userName = userName;
        setPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
