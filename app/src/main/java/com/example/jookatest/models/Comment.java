package com.example.jookatest.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Comment {
    @SerializedName("_id")
    String _id;
    @SerializedName("post_id")
    String post_id;
    @SerializedName("sender_mail")
    String senderMail;
    @SerializedName("content")
    String content;
    @SerializedName("date")
    String date;

    public Comment() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
