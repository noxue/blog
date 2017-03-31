package com.noxue.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by noxue on 2017/3/30.
 */
@Entity
public class Item {
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", orderId=" + orderId +
                ", urlName='" + urlName + '\'' +
                ", title='" + title + '\'' +
                ", contentText='" + contentText + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                ", createdAt=" + createdAt +
                ", prevId=" + prevId +
                ", nextId=" + nextId +
                '}';
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long typeId;

    private Integer orderId;

    @Column(unique = true, length = 100)
    private String urlName;

    private String title;

    @Lob
    @Column(nullable = false)
    private String contentText;

    @Lob
    private String contentHtml;

    @CreatedDate
    private Date createdAt;

    private Long prevId;

    private Long nextId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getPrevId() {
        return prevId;
    }

    public void setPrevId(Long prevId) {
        this.prevId = prevId;
    }

    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        this.nextId = nextId;
    }
}
