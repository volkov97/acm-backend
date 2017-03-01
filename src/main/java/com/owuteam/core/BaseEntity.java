package com.owuteam.core;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    public BaseEntity() {
        this.id = null;
    }
}
