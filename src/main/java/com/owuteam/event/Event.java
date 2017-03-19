package com.owuteam.event;

import com.owuteam.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "acm_events")
public class Event extends BaseEntity {

    @Column(name = "title_ru")
    private String titleRU;

    @Column(name = "title_en")
    private String titleEN;

    @Column(name = "description_ru")
    private String descriptionRU;

    @Column(name = "description_en")
    private String descriptionEN;
    private Date date;

    @Column(name = "place_ru")
    private String placeRU;

    @Column(name = "place_en")
    private String placeEN;

    public Event() {
        super();
    }

    public Event(String titleRU, String titleEN, String descriptionRU, String descriptionEN, Date date, String placeRU, String placeEN) {
        this.titleRU = titleRU;
        this.titleEN = titleEN;
        this.descriptionRU = descriptionRU;
        this.descriptionEN = descriptionEN;
        this.date = date;
        this.placeRU = placeRU;
        this.placeEN = placeEN;
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

    public String getDescriptionRU() {
        return descriptionRU;
    }

    public void setDescriptionRU(String descriptionRU) {
        this.descriptionRU = descriptionRU;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlaceRU() {
        return placeRU;
    }

    public void setPlaceRU(String placeRU) {
        this.placeRU = placeRU;
    }

    public String getPlaceEN() {
        return placeEN;
    }

    public void setPlaceEN(String placeEN) {
        this.placeEN = placeEN;
    }
}
