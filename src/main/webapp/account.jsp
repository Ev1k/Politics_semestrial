<%@ page import="java.util.Objects" %>
<%@ page import="com.derezhenko.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="main.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>My info</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <br>
  <center><h1>My info</h1></center>
  <br>
  <br>
</div>
<div class="row">
  <div class="col-3"></div>
  <div class="col-3">
    <img alt="" class="img-thumbnail" src="${pageContext.request.contextPath}/images/<%=session.getValue("image-user").toString()%>">
<%--    <img alt="" class="img-thumbnail" src="/images/${filename}">--%>
  </div>
<%--  <%User user = null;%>--%>
<%--  <%if ((user = (User) request.getAttribute("user")) != null){%>--%>
  <% User user = (User) request.getAttribute("user");%>
  <div class="col-3">
    <form action="updateUser.jsp" method="post" class="form-horizontal">
      <div class="form-group">
        <%--@declare id="name"--%><label for="name" class="col-sm-2 control-label">Name:</label>
        <div class="col-sm-10">
          <input type="text" name="name" class="form-control" value="<%=user.getName()%>">
        </div>
      </div>
      <div class="form-group">
        <%--@declare id="email"--%><label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
          <input type="email" name="email" class="form-control" value="<%=user.getEmail()%>">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">update</button>
        </div>
      </div>
    </form>
<%--    <h4><%=user.getName()%></h4>--%>
<%--    <label class="form-label">Username</label>--%>
<%--    <input type="text" class="form-control" name="username" value="${user.getName()}" required>--%>
<%--    <label class="form-label">Email</label>--%>
<%--    <input type="text" class="form-control" name="email" value="<%=user.getEmail()%>" required>--%>
<%--    <label class="form-label">Contact no</label>--%>
<%--    <input type="text" class="form-control" name="phone_number" value="<%=user.getPhone_number()%>" required>--%>
<%--    <label class="form-label">Password</label>--%>
<%--    <input type="password" class="form-control" name="password" value="<%=user.getPassword()%>" required>--%>
  </div>
<%--  <%}%>--%>
  <div class="col-15"></div>
  <div class="col-3"></div>
  <div class="col-3">
    <div class="mb-3">
      <form enctype="multipart/form-data" method="post" action="/account">
        <p><input class="form-control" type="file" id="formFile" name="photo" multiple accept="image/*,image/jpeg">
        <br>
        <center><input type="submit" class="btn-outline-success rounded" value="submit"></center>
      </p>
      </form>
    </div>
  </div>
</div>
</body>
</html>
