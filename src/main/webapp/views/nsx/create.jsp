<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 14/03/2023
  Time: 01:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container">
    <h1 class="text-center">Nhà Sản Xuất</h1>
    <form action="/Assignment_PH23038_war_exploded/nsx/store" method="post">
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${nsx.ma}" />
                <c:if test="${not empty errMa}">
                        <div class="alert alert-danger">${errMa}</div>
                </c:if>
            </div>
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${nsx.ten}" />
                <c:if test="${not empty errTen}">
                        <div class="alert alert-danger">${errTen}</div>
                </c:if>
            </div>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary" type="submit">save</button>
        </div>
    </form>
</div>

