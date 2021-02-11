<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Rental Site Home</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/fontawesome-free/css/all.min.css" />" />
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="/resources/dist/css/adminlte.min.css" />" />
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <form:form modelAttribute="searchModel" class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <form:input path="word" class="form-control form-control-navbar" placeholder="商品検索" aria-label="Search" />
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit" name="search">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form:form>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto d-flex align-items-center">
<c:if test="${loginModel.member_id != 0}">
      <li class="nav-item pr-3">
        <div class="border bg-${loginModel.plan.plan_color} rounded" style="padding:3px 15px ;">${loginModel.plan.plan_name}</div>
      </li>
      <li class="nav-item pr-3">
        <span class="text-dark">今月の貸出可能枚数: </span><span class="text-success">
          <c:if test="${loginModel.plan.limit_cnt <= 1000}">${loginModel.plan.limit_cnt}枚</c:if>
          <c:if test="${loginModel.plan.limit_cnt > 1000}">無制限</c:if>
        </span>
      </li>
      <li class="nav-item pr-3">
        <span class="text-warning"><i class="fas fa-coins"></i> POINT: ${loginModel.total_point}</span>
      </li>
      <li class="nav-item">
        <a href="logout" class="btn btn-primary">ログアウト</a>
      </li>
</c:if>
<c:if test="${loginModel.member_id == 0}">
      <li class="nav-item">
        <a href="login" class="btn btn-primary">ログイン</a>
      </li>
</c:if>
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
          <i class="fas fa-th-large"></i>
        </a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
      <img src="<c:url value="/resources/dist/img/AdminLTELogo.png" />" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">RentalSite</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="<c:url value="/resources/dist/img/user${loginModel.icon_idx}.png" />" class="img-circle elevation-2" alt="User Image" />
        </div>
        <div class="info">
          <a href="#" class="d-block">
            ${loginModel.member_name}<c:if test="${loginModel.admin == 1}">&nbsp;<i class="fas fa-user-cog"></i></c:if>
          </a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="index" class="nav-link ${activeTop}">
                  <i class="fas fa-home nav-icon"></i>
                  <p>Top</p>
                </a>
              </li>
<c:if test="${loginModel.member_id != 0}">
              <li class="nav-item">
                <a href="modMember" class="nav-link ${activeModMember}">
                  <i class="fas fa-user nav-icon"></i>
                  <p>個人情報管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="rental" class="nav-link ${activeRental}">
                  <i class="fas fa-compact-disc nav-icon"></i>
                  <p>レンタル管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="history" class="nav-link ${activeHistory}">
                  <i class="fas fa-history nav-icon"></i>
                  <p>履歴管理</p>
                </a>
              </li>
  <c:if test="${loginModel.admin == 1}">
              <li class="nav-item">
                <a href="stock" class="nav-link ${activeStock}">
                  <i class="fas fa-cubes nav-icon"></i>
                  <p>在庫管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="remind" class="nav-link ${activeRemind}">
                  <i class="fas fa-exclamation-triangle nav-icon"></i>
                  <p>督促管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="info" class="nav-link ${activeInfo}">
                  <i class="fas fa-info-circle nav-icon"></i>
                  <p>情報管理</p>
                </a>
              </li>
  </c:if>
</c:if>
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <jsp:include page="${pName}.jsp" />

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2014-2020 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="<c:url value="/resources/plugins/jquery/jquery.min.js" />"></script>
<!-- jquery-validation -->
<script src="<c:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" />"></script>
<script src="<c:url value="/resources/plugins/jquery-validation/additional-methods.min.js" />"></script>
<script src="<c:url value="/resources/dist/js/validate.js" />"></script> <!-- 独自JS(バリデータ) -->
<!-- Bootstrap 4 -->
<script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/dist/js/adminlte.min.js" />"></script>
</body>
</html>
