package com.owuteam.news;

import com.owuteam.core.BaseEntity;
import com.owuteam.tags.Tag;
import com.owuteam.topic.Topic;
import com.owuteam.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_news")
public class News extends BaseEntity {

    @Column(name = "title_ru")
    private String titleRU;

    @Column(name = "title_en")
    private String titleEN;

    private String systemName;

    @Column(name = "content_ru")
    private String contentRU;

    @Column(name = "content_en")
    private String contentEN;

    @Column(name = "description_ru")
    private String descriptionRU;

    @Column(name = "description_en")
    private String descriptionEN;

    private int views;
    private int langId;

    @Column(name = "status_ru")
    private int statusRU;

    @Column(name = "status_en")
    private int statusEN;


    @OneToOne
    @JoinColumn(name = "creator_id")
    private User user;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL)
    private List<Topic> topics = new ArrayList<>();

    public News() {
        super();
    }

    public News(String titleRU, String titleEN, String systemName, String contentRU, String contentEN, String descriptionRU, String descriptionEN, int views, int langId, int statusRU, int statusEN) {
        this.titleRU = titleRU;
        this.titleEN = titleEN;
        this.systemName = systemName;
        this.contentRU = contentRU;
        this.contentEN = contentEN;
        this.descriptionRU = descriptionRU;
        this.descriptionEN = descriptionEN;
        this.views = views;
        this.langId = langId;
        this.statusRU = statusRU;
        this.statusEN = statusEN;
    }

    public String getTitleRU() {
        return titleRU;
    }

    public void setTitleRU(String titleRU) {
        this.titleRU = titleRU;
    }

    public String getTitleEN() {
        return titleEN;
    }

    public void setTitleEN(String titleEN) {
        this.titleEN = titleEN;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getContentRU() {
        return contentRU;
    }

    public void setContentRU(String contentRU) {
        this.contentRU = contentRU;
    }

    public String getContentEN() {
        return contentEN;
    }

    public void setContentEN(String contentEN) {
        this.contentEN = contentEN;
    }

    public String getDescriptionRU() {
        return descriptionRU;
    }

    public void setDescriptionRU(String descriptionRU) {
        this.descriptionRU = descriptionRU;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
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

    public int getStatusRU() {
        return statusRU;
    }

    public void setStatusRU(int statusRU) {
        this.statusRU = statusRU;
    }

    public int getStatusEN() {
        return statusEN;
    }

    public void setStatusEN(int statusEN) {
        this.statusEN = statusEN;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tagItem) {
        tags.add(tagItem);
    }

    public void addTopic(Topic topicItem) {
        topics.add(topicItem);
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
