package com.owuteam.tags;

import com.owuteam.core.BaseEntity;
import com.owuteam.news.News;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_tags")
public class Tag extends BaseEntity {
    private String nameRU;
    private String nameEN;

    public Tag() {
        super();
    }

    public Tag(String nameRU, String nameEN) {
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
