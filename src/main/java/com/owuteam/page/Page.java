package com.owuteam.page;

import com.owuteam.core.BaseEntity;
import com.owuteam.section.ChampSection;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "acm_pages")
public class Page extends BaseEntity {

    @Size(min = 1, max = 80)
    private String titleRU;

    @Size(min = 1, max = 80)
    private String titleEN;

    @NotNull
    @Column(unique = true)
    @Size(min = 1, max = 80)
    private String systemName;

    @Lob
    @Type(type = "text")
    private String contentRU;

    @Lob
    @Type(type = "text")
    private String contentEN;

    @ManyToOne
    @JoinColumn(name = "champ_section_id")
    private ChampSection champSection;

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

    public ChampSection getChampSection() {
        return champSection;
    }

    public void setChampSection(ChampSection champSection) {
        this.champSection = champSection;
    }
}
