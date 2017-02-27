package com.owuteam.news;

import com.owuteam.core.BaseEntity;
import com.owuteam.user.User;

import javax.persistence.*;

@Entity
@Table(name = "acm_news")
public class News extends BaseEntity {

    private String title;
    private String systemName;
    private String content;
    private int views;
    private int langId;
    private int status;

    @OneToOne
    @JoinColumn(name = "creator_id")
    private User user;

    public News() {
        super();
    }

    public News(String title, String systemName, String content, int views, int langId, int status, User user) {
        super();
        this.title = title;
        this.systemName = systemName;
        this.content = content;
        this.views = views;
        this.langId = langId;
        this.status = status;
        this.user = user;
    }

    public News(String title, String systemName, String content, int views, int langId, int status) {
        super();
        this.title = title;
        this.systemName = systemName;
        this.content = content;
        this.views = views;
        this.langId = langId;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
