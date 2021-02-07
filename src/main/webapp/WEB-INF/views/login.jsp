<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Rental Site Login</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/fontawesome-free/css/all.min.css" />" />
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="/resources/dist/css/adminlte.min.css" />" />
</head>
<body class="hold-transition sidebar-mini" style="background-color: #f4f6f9;">
  <div class="wrapper" style="width: 600px;margin: 100px auto;">
            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Rental Site ログインフォーム</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form:form modelAttribute="loginModel" class="form-horizontal">
                <form:hidden path="name" value="Guest User" />
                <div class="card-body">
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                      <form:input path="email" class="form-control" id="inputEmail3" placeholder="Email" />
                      <div class="text-danger">${errorMessage}</div>
                      <form:errors path="email" element="div" cssClass="text-danger" />
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                      <form:password path="password" class="form-control" id="inputPassword3" placeholder="Password" />
                      <form:errors path="password" element="div" cssClass="text-danger" />
                    </div>
                  </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-info">ログイン</button>
                  <button type="button" class="btn btn-default float-right" onclick="history.back()">キャンセル</button>
                </div>
                <!-- /.card-footer -->
              </form:form>
            </div>
            <!-- /.card -->
            <p>アカウントをお持ちでない方は<a href="addMember">新規登録</a>へ</p>
  </div>
  <!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="<c:url value="/resources/plugins/jquery/jquery.min.js" />"></script>

<!-- Bootstrap 4 -->
<script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/dist/js/adminlte.min.js" />"></script>
</body>
</html>
