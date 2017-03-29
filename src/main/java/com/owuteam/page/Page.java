package com.owuteam.page;

import com.owuteam.core.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "acm_pages")
public class Page extends BaseEntity {
    private String title;

    @Lob
    @Type(type = "text")
    private String content;

    public Page() {
        super();
    }

    public Page(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
