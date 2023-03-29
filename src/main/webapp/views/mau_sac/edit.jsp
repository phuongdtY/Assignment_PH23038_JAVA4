<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 13/03/2023
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h1 class="text-center">Màu sắc</h1>
    <form action="/Assignment_PH23038_war_exploded/mau-sac/update?ma=${ms.ma}" method="post">
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${ms.ma}" disabled />
            </div>
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${ms.ten}" />
            </div>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary" type="submit">save</button>
        </div>
    </form>
</div>
