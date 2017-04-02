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
    private String name;

    @OneToMany
    @JoinColumn(name = "section_id")
    private List<Page> pages = new ArrayList<>();

    public ChampSection() {
        super();
    }

    public ChampSection(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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