package com.iqas.server.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class KbModel {

    private ObjectId _id;
    private Integer kbId;
    private String name;
    @Field
    private List<Integer> docId;
    private Date creationDate = new Date();

    public KbModel() {
    }

    public KbModel(String name) {
        super();
        this.name = name;
        this.docId=new ArrayList();
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public List<Integer> getDocId() {
        return docId;
    }

    public void setDocId(List<Integer> docId) {
        this.docId = docId;
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
