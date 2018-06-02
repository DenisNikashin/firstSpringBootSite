package com.examle.messageManager.domaine;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getTextMessage() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTextMessage(String text) {
        this.text = text;
    }
}
