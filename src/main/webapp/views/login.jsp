<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<div class="container">
    <c:if test="${ f:length(errorMessage) !=0 }">
        <div class="alert alert-danger" >${ errorMessage }</div>
    </c:if>
    <form action="/Assignment_PH23038_war_exploded/login" method="post">
        <div class="mb-3">
            <label class="form-label h6">Mã nhân viên</label>
            <input type="text" class="form-control" name="ma" >
        </div>
        <div class="mb-3">
            <label class="form-label h6">Mật khẩu</label>
            <input type="text" class="form-control" name="matKhau" >
        </div>
        <div class="mb-3">
            <button class="btn btn-primary" >Đăng nhập</button>
        </div>
    </form>
</div>
