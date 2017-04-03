package com.owuteam.section;

import com.owuteam.core.BaseEntity;
import com.owuteam.page.Page;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_champSections")
public class ChampSection extends  BaseEntity {
    private String titleRU;
    private String titleEN;

    @OneToMany
    @JoinColumn(name = "section_id")
    private List<Page> pages = new ArrayList<>();

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

    public void addPage(Page pageItem) {
        pages.add(pageItem);
    }
}