package com.owuteam.topic;

import com.owuteam.core.BaseEntity;
import com.owuteam.news.News;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "acm_topics")
public class Topic extends BaseEntity {

    @Size(min = 1, max = 80)
    private String nameRU;

    @Size(min = 1, max = 80)
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
