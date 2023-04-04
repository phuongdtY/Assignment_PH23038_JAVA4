
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="table-responsive">
    <div class="form-label text-center h1"> Màu Sắc</div>
    <a class="btn btn-primary " href="/Assignment_PH23038_war_exploded/mau-sac/create">Add</a>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <c:if test="${f:length(listMs) == 0}">
            <h3 class="alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(listMs) != 0}">
            <tbody>
            <c:forEach items="${listMs}" var="ms">
                <tr class="">
                    <td scope="row">${ms.ma} </td>
                    <td scope="row">${ms.ten}</td>
                    <td scope="row">
                        <a class="btn btn-primary" href="/Assignment_PH23038_war_exploded/mau-sac/edit?ma=${ms.ma}">
                            Edit
                        </a>
                        <a class="btn btn-danger" href="/Assignment_PH23038_war_exploded/mau-sac/delete?ma=${ms.ma}">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>
    </table>
</div>
