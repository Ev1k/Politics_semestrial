<%@ page import="java.util.List" %>
<%@ page import="com.derezhenko.model.PostDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="main.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<br>
<center><h1>PolitForum</h1><h2>News</h2></center>
<div class="container">
    <!-- Content here -->
    <div class="container">
        <div class="col-4"><h1>Список постов</h1></div>
        <div class="col-1"></div>
        <div class="col-2"><a class="btn btn-outline-success" href="/new-post">+Add post</a></div>
    </div>
    <br>
        <div class="row">
            <% for (PostDto post : (List<PostDto>) request.getAttribute("posts")) { %>
            <div class="col-md-6">
                <div class="card mb-3">
                    <div class="card-body">
                            <img src="${pageContext.request.contextPath}/images/<%=post.getPhoto()%>" alt="Аватар автора" class="rounded-circle me-3" height="40px" width="40px">
                            <a class="text-primary" href="/user/<%=post.getAuthorId()%>"><%=post.getAuthorName()%></a>
                        <h2 class="card-title"><%= post.getTitle() %></h2>
                        <p class="card-text"><%= post.getText() %></p>
                        <p class="card-text"><%= post.getDate() %></p>
<%--                        <form action="delete-post" method="post">--%>
<%--                            <input type="hidden" name="id" value="<%= post.getId() %>">--%>
<%--                            <button type="submit" class="btn btn-danger">Удалить</button>--%>
<%--                        </form>--%>
                    </div>
                </div>
            </div>
            <% } %>

        </div>

</div>
</body>
</html>
