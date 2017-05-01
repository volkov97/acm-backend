package com.owuteam.champ;

import com.owuteam.core.BaseEntity;
import com.owuteam.section.ChampSection;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acm_champs")
public class Champ extends BaseEntity {

    private String titleRU;
    private String titleEN;
    private int isOpen;
    private int year;
    private int status;
    private String systemName;


    @OneToMany(mappedBy = "champ", cascade = CascadeType.ALL)
    private List<ChampSection> sections = new ArrayList<>();

    public Champ() {
        super();
    }

    public Champ(String titleRU, String titleEN, int isOpen, int year, int status, String systemName) {
        this.titleRU = titleRU;
        this.titleEN = titleEN;
        this.isOpen = isOpen;
        this.year = year;
        this.status = status;
        this.systemName = systemName;
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

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
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

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}
