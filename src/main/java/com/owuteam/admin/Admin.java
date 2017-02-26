package com.owuteam.admin;

import com.owuteam.news.News;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String secondName;
    private String fatherName;
    private String password;
    private int rangId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<News> news = new ArrayList<>();

    public Admin() {
    }

    public Admin(String firstName, String secondName, String fatherName, String password, int rangId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fatherName = fatherName;
        this.password = password;
        this.rangId = rangId;
    }

    public Admin(String firstName, String secondName, String fatherName, String password, int rangId, List<News> news) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fatherName = fatherName;
        this.password = password;
        this.rangId = rangId;
        this.news = news;
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

    public int getRangId() {
        return rangId;
    }

    public void setRangId(int rangId) {
        this.rangId = rangId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addNews(News news) {
        news.setNewsAdmin(this);
        this.news.add(news);
    }
}
