<%@ page import="com.derezhenko.model.PostDto" %>
<%@ page import="com.derezhenko.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="main.jsp"%>
<html>
<head>
    <title>User info</title>
</head>
<body>
<%User user = (User) request.getAttribute("user");%>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <img class="rounded-circle me-3" height="200px" width="200px" src="${pageContext.request.contextPath}/images/<%=user.getPhoto()%>">
                <h3><%=user.getName()%></h3>
                <h3><%=user.getEmail()%></h3>
            </div>
            <div class="col-sm">
            </div>
            <div class="container">
            <div class="row">
            <% for (PostDto post : (List<PostDto>) request.getAttribute("posts")) { %>
                <div class="container">
                    <div class="row">
                        <div class="col-4"></div>
                        <div class="col-6">
                            <div class="shadow card-body rounded">
                                <img src="${pageContext.request.contextPath}/images/<%=post.getPhoto()%>" class="rounded-circle me-3" height="40px" width="40px">
                                <a class="text-primary" href="/user?id=<%=post.getAuthorId()%>"><%=post.getAuthorName()%></a>
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
                </div>

            <% } %>
            </div>
            </div>
        </div>
    </div>
</body>
</html>
