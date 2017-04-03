package com.owuteam.page;

import com.owuteam.core.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "acm_pages")
public class Page extends BaseEntity {
    private String titleRU;
    private String titleEN;
    private String systemName;

    @Lob
    @Type(type = "text")
    private String contentRU;

    @Lob
    @Type(type = "text")
    private String contentEN;

    public Page() {
        super();
    }

    public Page(String titleRU, String titleEN, String systemName, String contentRU, String contentEN) {
        this.titleRU = titleRU;
        this.titleEN = titleEN;
        this.systemName = systemName;
        this.contentRU = contentRU;
        this.contentEN = contentEN;
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
}
