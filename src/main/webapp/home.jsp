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

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <script>
        $(document).on("click", "#ajax-button", function () {
            console.log("Debug");
            alert("You have to login to add posts");
            $.get("/ajax/hello", function (response) {
                $("#ajax-response").text(response);
            })
        })
    </script>

    <style>
        .material-symbols-rounded {
            background-color: white;
            border: none;
            color: black;
            cursor: pointer;
            padding: 0px 0px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin-right: 10px;
            margin-left: 10px;
            font-variation-settings:
                    'FILL' 0,
                    'wght' 400,
                    'GRAD' 0,
                    'opsz' 24
        }
        .material-symbols-rounded.red {
            color: red;
            font-variation-settings:
                    'FILL' 0,
                    'wght' 400,
                    'GRAD' 0,
                    'opsz' 24
        }
        /*.like-count{*/
        /*    margin-bottom: 100px;*/
        /*}*/
         .material-symbols-outlined {
             /*background-color: white;*/
             /*border: none;*/
             /*color: black;*/
             cursor: pointer;
             padding: 0px 0px;
             text-align: center;
             text-decoration: none;
             display: inline-block;
             margin-right: 10px;
             margin-left: 240px;
             font-variation-settings:
                     'FILL' 0,
                     'wght' 400,
                     'GRAD' 0,
                     'opsz' 24
         }
    </style>
</head>
<body>
<br>
<center><h1>PolitForum</h1><h2>News</h2></center>
<div class="container">
    <div class="container">
        <div class="row">
        <div class="col-4"><h1>Posts list</h1></div>
            <div class="col-6"></div>
        <div class="col-2"><a class="btn btn-outline-success" href="/new-post">+Add post</a></div>
        </div>

        </div>
    <br>
        <div class="row">
            <% for (PostDto post : (List<PostDto>) request.getAttribute("posts")) { %>
            <div class="col-md-6">
                <div class="shadow card mb-3">
                    <div class="card-body">
                            <img src="${pageContext.request.contextPath}/images/<%=post.getPhoto()%>" class="rounded-circle me-3" height="40px" width="40px">
                            <a class="text-primary" href="/user?id=<%=post.getAuthorId()%>"><%=post.getAuthorName()%></a>
                        <h2 class="card-title"><%= post.getTitle() %></h2>
                        <p class="card-text"><%= post.getText() %></p>
                        <div class="container">
                            <span class="text-black-50"><%= post.getDate() %></span>
                            <a class="material-symbols-outlined nav-link" href="/post?id=<%=post.getId()%>">chat_bubble
                            </a>
                            <span class="comment-count">0</span>
                            <span class="material-symbols-rounded">favorite</span>
                            <span class="like-count">0</span>
                        </div>

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

<script>
    var likeBtns = document.querySelectorAll('.material-symbols-rounded');

    for (var i = 0; i < likeBtns.length; i++) {
        var btn = likeBtns[i];
        btn.addEventListener('click', function() {
            var countSpan = this.nextElementSibling;
            var count = parseInt(countSpan.textContent);
            if (this.classList.contains('red')) {
                count--;
                this.classList.remove('red');
            } else {
                count++;
                this.classList.add('red');
            }
            countSpan.textContent = count;
        });
    }
</script>
</body>
</html>
