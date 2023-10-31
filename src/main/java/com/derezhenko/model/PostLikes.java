package com.derezhenko.model;

public class PostLikes {
    int idPost;
    private String title;
    private String text;
    private String date;
    private int idAuthor;
    private String photo;
    private String name;
    private int countComment;
    private int countLikes;
    private int hasLike;

    public PostLikes(int idPost, String title, String text, String date, int idAuthor, String photo, String name, int countComment, int countLikes, int hasLike) {
        this.idPost = idPost;
        this.title = title;
        this.text = text;
        this.date = date;
        this.idAuthor = idAuthor;
        this.photo = photo;
        this.name = name;
        this.countComment = countComment;
        this.countLikes = countLikes;
        this.hasLike = hasLike;
    }

    public PostLikes(String title, String text, String date, int idAuthor, int countLikes, int hasLike) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.idAuthor = idAuthor;
        this.countLikes = countLikes;
        this.hasLike = hasLike;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
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

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(int countLikes) {
        this.countLikes = countLikes;
    }

    public int getHasLike() {
        return hasLike;
    }

    public void setHasLike(int hasLike) {
        this.hasLike = hasLike;
    }
}
