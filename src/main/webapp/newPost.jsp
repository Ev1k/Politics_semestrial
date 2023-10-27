<%@ page import="java.util.Objects" %>
<%@ page import="com.derezhenko.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="main.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="container">
        <br>
        <center><h2>Добавить новый пост</h2></center>
        <form action="/new-post" method="post">
            <div class="mb-3">
                <h3 for="exampleFormControlInput1" class="form-label">Title</h3>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="Title">
            </div>
            <div class="mb-3">
                <h3 for="exampleFormControlTextarea1" class="form-label">Type your text</h3>
                <textarea class="form-control" id="exampleFormControlTextarea1" name="text" rows="3" placeholder="Your text..."></textarea>
            </div>
            <%--        <label for="title">Заголовок:</label>--%>
            <%--        <input type="text" name="title" required><br>--%>
            <%--        <label for="text">Содержание:</label><br>--%>
            <%--        <textarea name="text" required></textarea><br>--%>
            <%--        <label for="author">Автор:</label>--%>
            <%--        <input type="text" name="author" required><br>--%>
            <input type="submit" class="btn btn-outline-success" value="Add post"></input>
        </form>
    </div>
</div>

</body>
</html>
