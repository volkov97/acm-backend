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

    private String title;
    private String systemName;
    private String content;
    private int views;
    private int langId;
    private int status;

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
