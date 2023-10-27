<#--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<html lang="en">
<#--<#include "main.ftl">-->
<#include "base.ftl">


<#macro title>Login</#macro>

<#macro content>
<body>
<div class="container">
    <br>
    <br>
    <br>
    <center><h1>Welcome to PolitForum</h1></center>
    <center><h5>Please, sign in account</h5></center>
    <br>
    <br>
    <br>
</div>
<div class="row">
    <div class="col-3"></div>
    <div class="col-3">
        <img alt="" class="img-fluid" src="https://i0.wp.com/vzv.su/polezno-znat/wp-content/uploads/2015/09/borba-s-konkurentami-voyna.jpg">
    </div>
<#--    <div class="col-1"></div>-->
    <div class="col-2">
        <form action="login" method="post">

            <label class="form-label">Username</label>
            <input type="text" class="form-control" name="username" required>

            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="password" required>

            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Remember me</label>
            <br>
            <br>
            <center>
            <button type="submit" class="w-100 btn btn-lg btn-outline-primary">Sign in</button>
                <br>
                <br>
            <center><a class="w-100 btn btn-lg btn-outline-warning" href="registration.jsp">Sign up</a></center>
<#--            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">-->
<#--                <span class="navbar-toggler-icon"></span>-->
<#--            </button>-->
            </center>
        </form>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/home">Home</a>
        </li>
    </div>
</div>
</body>
</#macro>
</html>
