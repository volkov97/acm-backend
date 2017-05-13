package com.owuteam.news;

import com.owuteam.core.BaseEntity;
import com.owuteam.tags.Tag;
import com.owuteam.topic.Topic;
import com.owuteam.user.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_news")
public class News extends BaseEntity {

    @Column(name = "title_ru")
    @Size(min = 1, max = 80)
    private String titleRU;

    @Column(name = "title_en")
    @Size(min = 1, max = 80)
    private String titleEN;

    @NotNull
    @Column(unique = true)
    @Size(min = 1, max = 80)
    private String systemName;

    @Lob
    @Type(type = "text")
    @Column(name = "content_ru")
    private String contentRU;

    @Lob
    @Type(type = "text")
    @Column(name = "content_en")
    private String contentEN;

    @Lob
    @Type(type = "text")
    @Column(name = "description_ru")
    private String descriptionRU;

    @Lob
    @Type(type = "text")
    @Column(name = "description_en")
    private String descriptionEN;

    private int views;

    @Column(name = "img")
    private String img;

    @Column(name = "status_ru")
    private int statusRU;

    @Column(name = "status_en")
    private int statusEN;

    @OneToOne
    @JoinColumn(name = "creator_id")
    private User user;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "News_Tags")
    private List<Tag> tags = new ArrayList<>();

    @OneToOne
    private Topic topic;

    public News() {
        super();
    }

    public News(String titleRU, String titleEN, String systemName, String contentRU, String contentEN, String descriptionRU, String descriptionEN, int views, int statusRU, int statusEN, String img) {
        this.titleRU = titleRU;
        this.titleEN = titleEN;
        this.systemName = systemName;
        this.contentRU = contentRU;
        this.contentEN = contentEN;
        this.descriptionRU = descriptionRU;
        this.descriptionEN = descriptionEN;
        this.views = views;
        this.statusRU = statusRU;
        this.statusEN = statusEN;
        this.img = img;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
