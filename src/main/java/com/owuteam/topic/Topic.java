package com.owuteam.topic;

import com.owuteam.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "acm_topics")
public class Topic extends BaseEntity {
    private String name;

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
