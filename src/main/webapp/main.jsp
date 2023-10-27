<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ПолитФорум</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Politforum</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/home">Home</a>
                    </li>
                    <%
                        String href1 = "/login";
                        String value1 = "Login";
                        String href2 = "/login";
                        String value2 = "Account";
                        if(session.getAttribute("username") != null) {
                            href1 = "logout";
                            value1 = "Logout";
                            value2 = "Logout";
                            href2 = "/account";
                        }
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=href1%>"><%=value1%></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=href2%>">Account</a>
                    </li>

<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="#">Pricing</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
<%--                    </li>--%>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <%
        if(session.getAttribute("username") == null) {
            response.sendRedirect("/login");
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"></script>
</body>
</html>
