<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 15/03/2023
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="table-responsive">
    <a class="btn btn-primary " href="/Assignment_PH23038_war_exploded/cua-hang/create">Add</a>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <c:if test="${f:length(listCh) == 0}">
            <h3 class="alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(listCh) != 0}">
            <tbody>
            <c:forEach items="${listCh}" var="ch">
                <tr class="">
                    <td scope="row">${ch.ma} </td>
                    <td scope="row">${ch.ten}</td>
                    <td scope="row">${ch.diaChi}</td>
                    <td scope="row">${ch.thanhPho}</td>
                    <td scope="row">${ch.quocGia}</td>
                    <td scope="row">
                        <a class="btn btn-primary" href="/Assignment_PH23038_war_exploded/cua-hang/edit?maCh=${ch.ma}">
                            Edit
                        </a>
                        <a class="btn btn-danger" href="/Assignment_PH23038_war_exploded/cua-hang/delete?maCh=${ch.ma}">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>
    </table>
</div>
<
