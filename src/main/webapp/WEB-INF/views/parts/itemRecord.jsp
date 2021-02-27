<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<tr>
  <td class="align-middle" style="width: 80px">
<c:if test="${item.new_old == 0}">
    <div class="border bg-danger rounded text-center small">NEW</div>
</c:if>
    <div class="border bg-${item.media.media_color} rounded text-center small">${item.media.media_name}</div>
  </td>
  <td class="align-middle">
    ${item.item_name}<br />
    <span class="small">${item.media_id != 0 ? "監督" : "アーティスト"}：${item.author_name}</span>
  </td>
  <td class="align-middle">
    <span class="text-warning"><i class="fas fa-coins"></i> ${item.add_point}</span>
  </td>  
  <td class="align-middle">
<c:if test="${loginModel.member_id == 0}">
    <button type="button" class="btn btn-outline-primary w-100 disabled">借りる</button>
</c:if>
<c:if test="${loginModel.member_id != 0}">
  <form:form modelAttribute="rentalModel">
    <form:hidden path="item_id" value="${item.item_id}" />
  <c:if test="${rentalIds.contains(item.item_id)}">
    <button type="button" class="btn btn-outline-warning w-100" data-toggle="modal" data-target="#modal-warning${item.item_id}">発送準備中</button>
    <div class="modal fade" id="modal-warning${item.item_id}">
      <div class="modal-dialog">
        <div class="modal-content bg-warning">
          <div class="modal-header">
            <h4 class="modal-title">キャンセル確認</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <p>[${item.item_name}]の発送をキャンセルします。<br />宜しいでしょうか？</p>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-outline-light" data-dismiss="modal">閉じる</button>
            <button type="submit" class="btn btn-outline-light" name="rentalDel">キャンセルする</button>
          </div>
        </div> <!-- /.modal-content -->
      </div> <!-- /.modal-dialog -->
    </div> <!-- /.modal -->
  </c:if>
  <c:if test="${!rentalIds.contains(item.item_id)}">
    <button type="submit" class="btn btn-outline-primary w-100" name="rentalAdd">借りる</button>
  </c:if>
  </form:form>
</c:if>
  </td>
</tr>