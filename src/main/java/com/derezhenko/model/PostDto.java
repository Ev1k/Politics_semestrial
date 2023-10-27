package com.derezhenko.model;

public class PostDto {
    int id;
    private String title;
    private String text;
    private String date;
    private String authorName;
    private String photo;
    private int authorId;


    public PostDto(int id, String title, String text, String date, String authorName, String photo, int authorId) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.authorName = authorName;
        this.photo = photo;
        this.authorId = authorId;
    }

    public PostDto(String title, String text, String date, String authorName, String photo, int authorId) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.authorName = authorName;
        this.photo = photo;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
