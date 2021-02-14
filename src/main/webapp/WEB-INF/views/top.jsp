<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-12">
            <h1 class="m-0">Welcom to Rental Site</h1>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div><!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="card card-primary card-tabs">
          <div class="card-header p-0 pt-1">
            <ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
<c:if test="${searchList != null}">
              <li class="nav-item">
                <a class="nav-link active" id="custom-tabs-ons-search-tab" data-toggle="pill" href="#custom-tabs-ons-search" role="tab" aria-controls="custom-tabs-ons-search" aria-selected="true">検索結果</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" id="custom-tabs-one-new-tab" data-toggle="pill" href="#custom-tabs-one-new" role="tab" aria-controls="custom-tabs-one-new" aria-selected="false">新作Top5</a>
              </li>
</c:if>
<c:if test="${searchList == null}">
              <li class="nav-item">
                <a class="nav-link active" id="custom-tabs-one-new-tab" data-toggle="pill" href="#custom-tabs-one-new" role="tab" aria-controls="custom-tabs-one-new" aria-selected="true">新作Top5</a>
              </li>
</c:if>
              <li class="nav-item">
                <a class="nav-link" id="custom-tabs-one-old-tab" data-toggle="pill" href="#custom-tabs-one-old" role="tab" aria-controls="custom-tabs-one-old" aria-selected="false">旧作Top5</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" id="custom-tabs-ons-all-tab" data-toggle="pill" href="#custom-tabs-ons-all" role="tab" aria-controls="custom-tabs-ons-all" aria-selected="false">全作品一覧</a>
              </li>
            </ul>
          </div>
          <div class="card-body">
            <div class="tab-content" id="custom-tabs-one-tabContent">
<c:if test="${searchList != null}">
              <!-- 検索結果 -->
              <div class="tab-pane fade show active" id="custom-tabs-ons-search" role="tabpanel" aria-labelledby="custom-tabs-ons-search-tab">
  <c:if test="${searchList.size() > 0}">
                <div class="card">
                  <div class="card-body p-0">
                    <table class="table table-striped">
                      <tbody>
    <c:forEach var="item" items="${searchList}">
      <%@ include file="parts/itemRecord.jsp" %>
    </c:forEach>
                       </tbody>
                     </table>
                   </div> <!-- /.card-body -->
                 </div> <!-- /.card -->
  </c:if>
  <c:if test="${searchList.size() == 0}">
                検索結果に該当する作品はありませんでした。
  </c:if>
              </div>
</c:if>
              <!-- 新作Top5 -->
              <div class="${searchList != null ? "tab-pane fade" : "tab-pane fade show active"}" id="custom-tabs-one-new" role="tabpanel" aria-labelledby="custom-tabs-one-new-tab">
                <div class="card">
                  <div class="card-body p-0">
                    <table class="table table-striped">
                      <tbody>
<c:forEach var="item" items="${newList}">
  <%@ include file="parts/itemRecord.jsp" %>
</c:forEach>
                       </tbody>
                     </table>
                   </div> <!-- /.card-body -->
                 </div> <!-- /.card -->
              </div>
              <!-- 旧作Top5 -->
              <div class="tab-pane fade" id="custom-tabs-one-old" role="tabpanel" aria-labelledby="custom-tabs-one-old-tab">
                <div class="card">
                  <div class="card-body p-0">
                    <table class="table table-striped">
                      <tbody>
<c:forEach var="item" items="${oldList}">
  <%@ include file="parts/itemRecord.jsp" %>
</c:forEach>
                       </tbody>
                     </table>
                   </div> <!-- /.card-body -->
                 </div> <!-- /.card -->
              </div>
              <!-- 全作品一覧 -->
              <div class="tab-pane fade" id="custom-tabs-ons-all" role="tabpanel" aria-labelledby="custom-tabs-ons-all-tab">
                <div class="card">
                  <div class="card-body p-0">
                    <table class="table table-striped">
                      <tbody>
<c:forEach var="item" items="${allList}">
  <%@ include file="parts/itemRecord.jsp" %>
</c:forEach>
                      </tbody>
                    </table>
                  </div> <!-- /.card-body -->
                </div> <!-- /.card -->
              </div>
            </div>
          </div> <!-- /.card -->
        </div>

      </div><!-- /.container-fluid -->
    </div><!-- /.content -->
  </div><!-- /.content-wrapper -->

