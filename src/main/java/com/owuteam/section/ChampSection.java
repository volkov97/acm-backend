package com.owuteam.section;

import com.owuteam.champ.Champ;
import com.owuteam.core.BaseEntity;
import com.owuteam.page.Page;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_champSections")
public class ChampSection extends  BaseEntity {
    private String titleRU;
    private String titleEN;

    @OneToMany(mappedBy = "champSection", cascade = CascadeType.ALL)
    private List<Page> pages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "champ_id")
    private Champ champ;

    public ChampSection() {
        super();
    }

    public ChampSection(String titleRU, String titleEN) {
        this.titleRU = titleRU;
        this.titleEN = titleEN;
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

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public Champ getChamp() {
        return champ;
    }

    public void setChamp(Champ champ) {
        this.champ = champ;
    }

    public void addPage(Page pageItem) {
        pages.add(pageItem);
    }
}