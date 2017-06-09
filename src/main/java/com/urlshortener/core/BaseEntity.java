package com.urlshortener.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    @javax.persistence.Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private final Long Id;

    protected BaseEntity() {
        Id = null;
    }
}
