package com.owuteam.lang;

import com.owuteam.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "acm_lang")
public class Language extends BaseEntity {
    private String langIso2;
    private String langIso3;

    public Language() {
        super();
    }

    public Language(String langIso2, String langIso3) {
        super();
        this.langIso2 = langIso2;
        this.langIso3 = langIso3;
    }

    public String getLangIso2() {
        return langIso2;
    }

    public void setLangIso2(String langIso2) {
        this.langIso2 = langIso2;
    }

    public String getLangIso3() {
        return langIso3;
    }

    public void setLangIso3(String langIso3) {
        this.langIso3 = langIso3;
    }
}
