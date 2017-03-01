package com.owuteam.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.owuteam.core.BaseEntity;
import com.owuteam.news.News;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_user")
public class User extends BaseEntity{
    @NotNull
    @Size(min = 1, max = 40)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 40)
    private String secondName;

    @NotNull
    @Size(min = 1, max = 40)
    private String fatherName;

    @NotNull
    @Size(min = 1, max = 40)
    private String userName;

    @JsonIgnore
    @NotNull
    private String password;

    @JsonIgnore
    private String[] roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<News> news = new ArrayList<>();

    protected User() {
        super();
    }

    public User(String firstName, String secondName, String fatherName, String userName, String password, String[] roles) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.fatherName = fatherName;
        this.userName = userName;
        setPassword(password);
        this.roles = roles;
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

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void addNews(News news) {
        news.setUser(this);
        this.news.add(news);
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
