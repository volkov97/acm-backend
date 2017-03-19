package com.owuteam.topic;

import com.owuteam.core.BaseEntity;
import com.owuteam.news.News;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "acm_topics")
public class Topic extends BaseEntity {

    private String name;

    @ManyToMany
    private List<News> news;

    public Topic() {
        super();
    }

    public Topic(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
