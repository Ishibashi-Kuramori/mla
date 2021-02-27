<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="content-wrapper"> <!-- Content Wrapper. Contains page content -->
  <div class="content-header"> <!-- Content Header (Page header) -->
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-12">
          <h1 class="m-0">レンタル管理</h1>
        </div><!-- /.col -->
      </div><!-- /.row -->
    </div><!-- /.container-fluid -->
  </div> <!-- /.content-header -->

  <!-- Main content -->
  <div class="content">
    <div class="container-fluid">
<c:if test="${rentalList.size() > 0}">
      <div class="card">
        <div class="card-body p-0">
          <table class="table table-striped">
            <tbody>
<c:forEach var="rental" items="${rentalList}">
  <c:set var="item" value="${rental.item}"/>
  <%@ include file="parts/itemRecord.jsp" %>
</c:forEach>
            </tbody>
          </table>
        </div> <!-- /.card-body -->
      </div> <!-- /.card -->
</c:if>
<c:if test="${rentalList.size() == 0}">
      <div class="card-body">
        <div class="alert alert-info alert-dismissible">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
          <h5><i class="icon fas fa-info"></i> Info</h5>
             まだ作品を借りていません。
        </div>
      </div>
</c:if>
    </div><!-- /.container-fluid -->
  </div><!-- /.content -->
</div><!-- /.content-wrapper -->