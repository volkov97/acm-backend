package com.owuteam.champ;

import com.owuteam.section.ChampSection;
import com.owuteam.core.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_champs")
public class Champ extends BaseEntity {

    private String name;
    private int year;
    private int status;

    @OneToMany
    @JoinColumn(name = "champ_id")
    private List<ChampSection> sections = new ArrayList<>();

    public Champ() {
        super();
    }

    public Champ(String name, int year, int status) {
        super();
        this.name = name;
        this.year = year;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ChampSection> getSections() {
        return sections;
    }

    public void setSections(List<ChampSection> sections) {
        this.sections = sections;
    }

    public void addSection(ChampSection sectionItem) {
        sections.add(sectionItem);
    }
}
