<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 15/03/2023
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="table-responsive">
    <a class="btn btn-primary " href="/Assignment_PH23038_war_exploded/chuc-vu/create">Add</a>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <c:if test="${f:length(listcv) == 0}">
            <h3 class="alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(listcv) != 0}">
            <tbody>
            <c:forEach items="${listcv}" var="cv">
                <tr class="">
                    <td scope="row">${cv.ma} </td>
                    <td scope="row">${cv.ten}</td>
                    <td scope="row">
                        <a class="btn btn-primary"
                           href="/Assignment_PH23038_war_exploded/chuc-vu/edit?ma=${cv.ma}" >
                            Edit
                        </a>
                        <a class="btn btn-danger"
                           href="/Assignment_PH23038_war_exploded/chuc-vu/delete?ma=${cv.ma}" >
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>
    </table>
</div>
