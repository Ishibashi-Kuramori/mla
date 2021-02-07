<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Rental Site 新規登録</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/fontawesome-free/css/all.min.css" />" />
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="/resources/dist/css/adminlte.min.css" />" />
  <style type="text/css">
img {
  width: 100px;
}
input[type="radio"] {
  display: none;
}
label img {
  margin: 3px;
  padding: 3px;
}
input[type="radio"]:checked + label img {
  background: orange;
}
  </style>
</head>
<body class="hold-transition sidebar-mini" style="background-color: #f4f6f9;">
  <div class="wrapper" style="width: 600px;margin: 100px auto;">
            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Rental Site 新規登録フォーム</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form:form modelAttribute="loginModel" class="form-horizontal">
                <div class="card-body">
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">お名前</label>
                    <div class="col-sm-10">
                      <form:input path="name" class="form-control" id="inputEmail3" placeholder="お名前" />
                      <form:errors path="name" element="div" cssClass="text-danger" />
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                      <form:input path="email" class="form-control" id="inputEmail3" placeholder="Email" />
                      <form:errors path="email" element="div" cssClass="text-danger" />
                      <div class="text-danger">${errorMessage}</div>
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                      <form:password path="password" class="form-control" id="inputPassword3" placeholder="Password" />
                      <form:errors path="password" element="div" cssClass="text-danger" />
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">お支払い</label>
                    <div class="col-sm-10">
                        <form:select path="pay_id" class="custom-select">
<c:forEach var="pay" items="${payList}">
                          <option value="${pay.pay_id}">${pay.pay_name}</option>
</c:forEach>
                        </form:select>
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">イメージ</label>
                    <div class="col-sm-10">
                      <div class="row">
                        <div class="col-sm-3">
                          <form:radiobutton path="icon_idx" value="1" id="icon1" checked="true" />
                          <label for="icon1"><img src="<c:url value="/resources/dist/img/user1.png" />" class="img-circle elevation-2" alt="User Image" /></label>
                        </div>
                        <div class="col-sm-3">
                          <form:radiobutton path="icon_idx" value="2" id="icon2" />
                          <label for="icon2"><img src="<c:url value="/resources/dist/img/user2.png" />" class="img-circle elevation-2" alt="User Image" /></label>
                        </div>
                        <div class="col-sm-3">
                          <form:radiobutton path="icon_idx" value="3" id="icon3" />
                          <label for="icon3"><img src="<c:url value="/resources/dist/img/user3.png" />" class="img-circle elevation-2" alt="User Image" /></label>
                        </div>
                        <div class="col-sm-3">
                          <form:radiobutton path="icon_idx" value="4" id="icon4" />
                          <label for="icon4"><img src="<c:url value="/resources/dist/img/user4.png" />" class="img-circle elevation-2" alt="User Image" /></label>
                        </div>
                        <div class="col-sm-3">
                          <form:radiobutton path="icon_idx" value="5" id="icon5" />
                          <label for="icon5"><img src="<c:url value="/resources/dist/img/user5.png" />" class="img-circle elevation-2" alt="User Image" /></label>
                        </div>
                        <div class="col-sm-3">
                          <form:radiobutton path="icon_idx" value="6" id="icon6" />
                          <label for="icon6"><img src="<c:url value="/resources/dist/img/user6.png" />" class="img-circle elevation-2" alt="User Image" /></label>
                        </div>
                        <div class="col-sm-3">
                          <form:radiobutton path="icon_idx" value="7" id="icon7" />
                          <label for="icon7"><img src="<c:url value="/resources/dist/img/user7.png" />" class="img-circle elevation-2" alt="User Image" /></label>
                        </div>
                        <div class="col-sm-3">
                          <form:radiobutton path="icon_idx" value="8" id="icon8" />
                          <label for="icon8"><img src="<c:url value="/resources/dist/img/user8.png" />" class="img-circle elevation-2" alt="User Image" /></label>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-info">登録</button>
                  <button type="button" class="btn btn-default float-right" onclick="history.back()">キャンセル</button>
                </div>
                <!-- /.card-footer -->
              </form:form>
            </div>
            <!-- /.card -->
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
