<%@ page import="com.derezhenko.model.PostDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.derezhenko.model.CommentDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="main.jsp"%>
<html>
<head>
    <title>Post</title>
</head>
<body>
<div class="container">
    <div class="row">
        <% PostDto post = (PostDto) request.getAttribute("post");  %>
        <div class="container">
            <div class="row">
                <div class="col-1"></div>
                <div class="col-10">
                    <div class="shadow card-body  rounded">
                        <img src="${pageContext.request.contextPath}/images/<%=post.getPhoto()%>" class="rounded-circle me-3" height="40px" width="40px">
                        <a class="text-primary" href="/user?id=<%=post.getAuthorId()%>"><%=post.getAuthorName()%></a>
                        <h2 class="card-title"><%= post.getTitle() %></h2>
                        <p class="card-text"><%= post.getText() %></p>
                        <span class="text-black-50"><%= post.getDate() %></span>
                        <%--                        <form action="delete-post" method="post">--%>
                        <%--                            <input type="hidden" name="id" value="<%= post.getId() %>">--%>
                        <%--                            <button type="submit" class="btn btn-danger">Удалить</button>--%>
                        <%--                        </form>--%>
                    </div>
                </div>
            </div>
            <br>

            <% for (CommentDto comment: (List<CommentDto>) request.getAttribute("comments")){%>
<%--        get comments list    --%>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">
                    <div class="shadow-sm card-body border rounded">
                        <img src="${pageContext.request.contextPath}/images/<%=comment.getAuthorPhoto()%>" class="rounded-circle me-3" height="40px" width="40px">
                        <a class="text-primary" href="/user?id=<%=post.getAuthorId()%>"><%=comment.getAuthorName()%></a>
                        <h2 class="card-title"><%= comment.getText() %></h2>
                        <span class="text-black-50"><%= comment.getDate() %></span>
                    </div>
                </div>
            </div>
            <%}%>

<%--          add  comment--%>
            <br>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">
                    <form action="/post?id=<%=post.getId()%>" method="post">
                        <div class="mb-3">
                            <h4 for="exampleFormControlTextarea1" class="form-label">Comment</h4>
                            <textarea class="form-control" id="new-comment" name="text" rows="3" placeholder="Your text..."></textarea>
                        </div>
                        <input type="submit" class="btn btn-outline-success" value="Add comment"></input>
                    </form>
                </div>
            </div>
            <br>
            <br>
            <br>
        </div>

        <%  %>
    </div>
</div>
</body>
</html>
