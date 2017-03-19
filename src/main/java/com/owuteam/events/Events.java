package com.owuteam.events;

import com.owuteam.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "acm_events")
public class Events extends BaseEntity {
    private String title;
    private String description;
    private Date date;
    private String place;

    public Events() {
        super();
    }

    public Events(String title, String description, Date date, String place) {
        super();
        this.title = title;
        this.description = description;
        this.date = date;
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
