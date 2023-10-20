<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Личный кабинет</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <br>
  <br>
  <br>
  <center><h1>Личный кабинет</h1></center>
  <br>
  <br>
  <br>
</div>
<div class="row">
  <div class="col-3"></div>
  <div class="col-3">
<%--    <img alt="" class="img-thumbnail" src="https://i0.wp.com/vzv.su/polezno-znat/wp-content/uploads/2015/09/borba-s-konkurentami-voyna.jpg">--%>
<%--    <img alt="" class="img-thumbnail" src="C:/Users/Эвелина/AppData/Local/JetBrains/IntelliJIdea2022.2/tomcat/5077d436-afab-4425-8a77-007cfa00fd72/work/Catalina/localhost/ROOT<%=imgName%>">--%>
    <img alt="" class="img-thumbnail" src="${pageContext.request.contextPath}/images/<%=session.getValue("image-user").toString()%>">
  </div>
  <div class="col-15"></div>
  <div class="col-3"></div>
  <div class="col-3">
    <div class="mb-3">
      <form enctype="multipart/form-data" method="post" action="/account">
        <p><input class="form-control" type="file" id="formFile" name="photo" multiple accept="image/*,image/jpeg">
        <br>
        <center><input type="submit" class="btn-outline-success rounded" value="Отправить"></center>
      </p>
      </form>
    </div>
  </div>
</div>
</body>
</html>
