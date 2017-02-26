package com.owuteam.news;

import com.owuteam.core.BaseEntity;


import javax.persistence.Entity;

@Entity
public class News extends BaseEntity {

    private String title;
    private String systemName;
    private String content;
    private int views;
    private int langId;
    private int status;
    // private int creator_id;

    public News() {
        super();
    }

    public News(String title, String systemName, String content, int views, int langId, int status) {
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
}
