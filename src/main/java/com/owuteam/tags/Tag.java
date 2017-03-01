package com.owuteam.tags;

import com.owuteam.core.BaseEntity;
import com.owuteam.news.News;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "acm_tags")
public class Tag extends BaseEntity {
    @NotNull
    private String name;

    public Tag() {
        super();
    }

    public Tag(String name) {
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
