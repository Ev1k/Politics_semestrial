<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <br>
  <br>
  <br>
  <center><h1>Добро пожаловать на ПолитФорум</h1></center>
  <center><h5>Добро пожаловать на ПолитФорум</h5></center>
  <br>
  <br>
  <br>
</div>
<div class="row">
  <div class="col-3"></div>
  <div class="col-3">
    <img alt="" class="img-thumbnail" src="https://i0.wp.com/vzv.su/polezno-znat/wp-content/uploads/2015/09/borba-s-konkurentami-voyna.jpg">
  </div>
  <div class="col-1"></div>
  <div class="col-2">
    <form action="login" method="post">

      <label class="form-label">Username</label>
      <input type="text" class="form-control" name="username" required>

      <label class="form-label">Password</label>
      <input type="password" class="form-control" name="password" required>

      <input type="checkbox" class="form-check-input" id="exampleCheck1">
      <label class="form-check-label" for="exampleCheck1">Запомнить меня</label>
      <br>
      <br>
      <button type="submit" class="btn-outline-primary rounded">Войти</button>
    </form>
  </div>
</div>

<!--<form action="login" method="post">-->
<!--  Login:-->
<!--  <input type="text" name="login"/>-->
<!--  <br>-->
<!--  Password:-->
<!--  <input type="password" name="password"/>-->
<!--  <br>-->
<!--  <input type="checkbox" id="rememberMe" name="rememberMe">-->
<!--  <label for="rememberMe">Запомнить меня</label>-->
<!--  <br>-->
<!--  <input type="submit" value="login">-->
<!--</form>-->
</body>
</html>
