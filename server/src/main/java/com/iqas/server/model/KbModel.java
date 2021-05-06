package com.iqas.server.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class KbModel {


    private Integer kbId;
    private String name;
    private Date creationDate = new Date();

    public KbModel() {
    }

    public KbModel(Integer kbId, String name) {
        super();
        this.kbId = kbId;
        this.name = name;
    }

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
