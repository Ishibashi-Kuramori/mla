<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
.form-horizontal {
  width: 600px;
}
  </style>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-12">
            <h1 class="m-0">個人情報管理</h1>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <!-- form start -->
        <form:form modelAttribute="loginModel" class="form-horizontal">
          <form:hidden path="member_id" value="${loginModel.member_id}" />
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
                <form:password path="password" class="form-control" id="inputPassword3" placeholder="Password" value="${loginModel.password}" />
                <form:errors path="password" element="div" cssClass="text-danger" />
              </div>
            </div>
            <div class="form-group row">
              <label for="inputPassword3" class="col-sm-2 col-form-label">お支払い</label>
              <div class="col-sm-10">
                  <form:select path="pay_id" class="custom-select">
<c:forEach var="pay" items="${payList}">
  <c:choose>
    <c:when test="${pay.pay_id == loginModel.pay_id}">
	                <option value="${pay.pay_id}" selected="selected">${pay.pay_name}</option>
    </c:when>
    <c:otherwise>
                    <option value="${pay.pay_id}">${pay.pay_name}</option>
    </c:otherwise>
  </c:choose>
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
            <div class="form-group row">
              <label for="inputPassword3" class="col-sm-2 col-form-label">プラン</label>
              <div class="col-sm-10">
                  <form:select path="plan_id" class="custom-select">
<c:forEach var="plan" items="${planList}">
  <c:choose>
    <c:when test="${plan.plan_id == loginModel.plan_id}">
	                <option value="${plan.plan_id}" selected="selected">${plan.plan_name}</option>
    </c:when>
    <c:otherwise>
                   <option value="${plan.plan_id}">${plan.plan_name}</option>
    </c:otherwise>
  </c:choose>
</c:forEach>
                  </form:select>
              </div>
            </div>
            <div class="form-group row">
<c:forEach var="plan" items="${planList}">
              <div class="col-md-3">
                <div class="card card-${plan.plan_color}">
                  <div class="card-header">
                    <h3 class="card-title">${plan.plan_name}</h3>
                  </div>
                  <div class="card-body">
                    <small>
                      <c:if test="${plan.limit_cnt <= 1000}">上限：${plan.limit_cnt}枚/月</c:if>
                      <c:if test="${plan.limit_cnt > 1000}">上限：∞枚/月</c:if>
                      <br />
                          月額：${plan.monthly}円
                    </small>
                  </div> <!-- /.card-body -->
                </div>            
              </div>            
</c:forEach>
            </div>
          </div> <!-- /.card-body -->
          <div class="card-footer">
            <button type="submit" class="btn btn-info" name="update">更新</button>
            <button type="button" class="btn btn-danger float-right" data-toggle="modal" data-target="#modal-danger">退会</button>
            <button type="reset" class="btn btn-default float-right mr-3">リセット</button>
          </div> <!-- /.card-footer -->
          
  <div class="modal fade" id="modal-danger">
    <div class="modal-dialog">
      <div class="modal-content bg-danger">
        <div class="modal-header">
          <h4 class="modal-title">退会確認</h4>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <p>退会すると会員情報、及び関連データが削除されます。<br />宜しいでしょうか？</p>
        </div>
        <div class="modal-footer justify-content-between">
          <button type="button" class="btn btn-outline-light" data-dismiss="modal">閉じる</button>
          <button type="submit" class="btn btn-outline-light" name="delete">退会する</button>
        </div>
      </div> <!-- /.modal-content -->
    </div> <!-- /.modal-dialog -->
  </div> <!-- /.modal -->
          
        </form:form>
      </div> <!-- /.container-fluid -->
    </div> <!-- /.content -->
  </div> <!-- /.content-wrapper -->