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

    private String nameRU;
    private String nameEN;

    public Topic() {
        super();
    }

    public Topic(String nameRU, String nameEN) {
        this.nameRU = nameRU;
        this.nameEN = nameEN;
    }

    public String getNameRU() {
        return nameRU;
    }

    public void setNameRU(String nameRU) {
        this.nameRU = nameRU;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }
}
