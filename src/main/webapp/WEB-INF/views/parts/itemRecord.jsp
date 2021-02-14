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
    <span class="small">${item.media_id != 0 ? "監督" : "アーティスト"}：${item.author_name}</span></td>
  <td class="align-middle">
    <button type="button" class="btn btn-outline-primary w-100 ${loginModel.member_id != 0 ? "" : "disabled"}">借りる</button>
  </td>
</tr>