package com.iqas.server.model;

import java.util.Date;

public class DocumentModel {

 private Integer docId;
 private String name;
 private String text;
 private Date creationDate=new Date();


 public DocumentModel() {
 }

 public DocumentModel(String name, String text) {
  super();
  this.name = name;
  this.text = text;
 }

 public Integer getDocId() {
  return docId;
 }

 public void setDocId(Integer docId) {
  this.docId = docId;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getText() {
  return text;
 }

 public void setText(String text) {
  this.text = text;
 }

 public Date getCreationDate() {
  return creationDate;
 }

 public void setCreationDate(Date creationDate) {
  this.creationDate = creationDate;
 }
}
