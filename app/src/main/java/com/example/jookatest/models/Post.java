package com.example.jookatest.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Post {
    @SerializedName("_id")
    String _id;
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
    @SerializedName("date")
    String date;
    @SerializedName("sender_mail")
    String senderMail;
    @SerializedName("thumbnail")
    String thumbnail;

    public Post() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
