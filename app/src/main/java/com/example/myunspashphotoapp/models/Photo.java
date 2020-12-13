package com.example.myunspashphotoapp.models;

import android.net.Uri;

import java.util.Map;

public class Photo<DateTime> {
    private String id;
    private DateTime created_at;
    private DateTime updated_at;
    private String description;
    private String alt_description;
    private int likes;
    private Map<String, String> urls;
    private String small_urls;

    public String getSmall_urls() {
        return urls.get("small");
    }

    public Photo(String id, DateTime created_at, DateTime updated_at, String description, String alt_description, int likes, Map<String, String> urls) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.alt_description = alt_description;
        this.likes = likes;
        this.urls = urls;
    }

    public Photo() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(DateTime created_at) {
        this.created_at = created_at;
    }

    public DateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(DateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlt_description() {
        return alt_description;
    }

    public void setAlt_description(String alt_description) {
        this.alt_description = alt_description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls =urls;
    }
}
