package com.noxue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by noxue on 2017/4/3.
 */
@Entity
public class Attach {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String mime;

    private boolean used;


    public Attach(String path, String mime, boolean used) {
        this.path = path;
        this.mime = mime;
        this.used = used;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }
}
