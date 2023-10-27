package com.derezhenko.model;

public class Post {
    int id;
    private String title;
    private String text;
    private String date;
    private int authorId;

    public Post(int id, String title, String text, String date, int authorId) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.authorId = authorId;
    }

    public Post(String title, String text, String date, int authorId) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthor(int authorId) {
        this.authorId = authorId;
    }
}
