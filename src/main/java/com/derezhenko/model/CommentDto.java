package com.derezhenko.model;

public class CommentDto {
    int id;
    private int idPost;
    private int idAuthor;
    private String text;
    private String authorName;
    private String authorPhoto;
    private String date;

    public CommentDto(int idPost, int idAuthor, String text, String date) {
        this.idPost = idPost;
        this.idAuthor = idAuthor;
        this.text = text;
        this.date = date;
    }

    public CommentDto(int id, int idPost, int idAuthor, String text, String authorName, String authorPhoto, String date) {
        this.id = id;
        this.idPost = idPost;
        this.idAuthor = idAuthor;
        this.text = text;
        this.authorName = authorName;
        this.authorPhoto = authorPhoto;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPhoto() {
        return authorPhoto;
    }

    public void setAuthorPhoto(String authorPhoto) {
        this.authorPhoto = authorPhoto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
