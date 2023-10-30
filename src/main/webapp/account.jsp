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
    <form enctype="multipart/form-data" method="post" action="/account">
      <p><input class="form-control" type="file" id="formFile" name="photo" multiple accept="image/*,image/jpeg">
        <br>
      <center><input type="submit" class="btn-outline-success rounded" value="submit"></center>
      </p>
    </form>
  </div>
  <div class="col-3">
    <form action="/update" method="post" class="form-horizontal">
      <div class="form-group">
        <%--@declare id="name"--%><label for="name" class="col-sm-2 control-label">Name:</label>
        <div class="col-sm-10">
          <input type="text" name="name" class="form-control" value="<%=session.getAttribute("username")%>">
        </div>
      </div>
      <br>
      <div class="form-group">
        <%--@declare id="email"--%><label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
          <input type="email" name="email" class="form-control" value="<%=session.getAttribute("email")%>">
        </div>
      </div>
      <br>
      <div class="form-group">
        <%--@declare id="phone"--%><label for="phone" class="col-sm-10 control-label">Phone number:</label>
        <div class="col-sm-10">
          <input type="number" name="phone" class="form-control" value="<%=session.getAttribute("phone")%>">
        </div>
      </div>
      <br>
      <div class="form-group">
        <%--@declare id="password"--%><label for="password" class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-10">
          <input type="password" name="password" class="form-control" value="<%=session.getAttribute("password")%>">
        </div>
      </div>
      <br>
      <div class="form-group">
        <%--@declare id="password2"--%><label for="password2" class="col-sm-10 control-label">Repeat password:</label>
        <div class="col-sm-10">
          <input type="password" name="password2" class="form-control" value="">
        </div>
      </div>
      <br>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">update</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
