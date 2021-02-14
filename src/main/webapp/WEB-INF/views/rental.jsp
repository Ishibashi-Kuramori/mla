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


                <div class="card">
                  <div class="card-body p-0">
                    <table class="table table-striped">
                      <tbody>
<c:forEach var="rental" items="${rentalList}">
                         <tr>
                           <td class="align-middle" style="width: 80px">
<c:if test="${rental.item.new_old == 0}">
                             <div class="border bg-danger rounded text-center small">NEW</div>
</c:if>
                             <div class="border bg-${rental.item.media.media_color} rounded text-center small">${rental.item.media.media_name}</div>
                           </td>
                           <td class="align-middle">
                             ${rental.item.item_name}<br />
                             <span class="small">${rental.item.media_id != 0 ? "監督" : "アーティスト"}：${rental.item.author_name}</span></td>
                           <td class="align-middle">
                           </td>
                         </tr>
</c:forEach>
                       </tbody>
                     </table>
                   </div> <!-- /.card-body -->
                 </div> <!-- /.card -->

    </div><!-- /.container-fluid -->
  </div><!-- /.content -->
</div><!-- /.content-wrapper -->