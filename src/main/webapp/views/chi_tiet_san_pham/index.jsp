<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 15/03/2023
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="table-responsive">
    <div class="form-label text-center h1"> Chi Tiết Sản Phẩm</div>
    <a class="btn btn-primary " href="/Assignment_PH23038_war_exploded/chi-tiet-san-pham/create">Add</a>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Sản phẩm</th>
            <th scope="col">Nhà sản xuất</th>
            <th scope="col">Màu sắc</th>
            <th scope="col">Dòng sản phẩm</th>
            <th scope="col">Năm bảo hành
            <th scope="col">Mô tả</th>
            <th scope="col">Số lượng tồn</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Giá bán</th>
            <th scope="col">Thao Tác</th>
        </tr>
        </thead>
        <c:if test="${f:length(listctsp) == 0}">
            <h3 class="alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(listctsp) != 0}">
            <tbody>
            <c:forEach items="${listctsp}" var="ctsp">
                <tr class="">
                    <td scope="row">${ctsp.id} </td>
                    <td scope="row">${ctsp.sanPham.ten}</td>
                    <td scope="row">${ctsp.nsx.ten}</td>
                    <td scope="row">${ctsp.mauSac.ten}</td>
                    <td scope="row">${ctsp.dongSanPham.ten}</td>
                    <td scope="row">${ctsp.namBaoHanh}</td>
                    <td scope="row">${ctsp.moTa}</td>
                    <td scope="row">${ctsp.soLuongTon}</td>
                    <td scope="row">${ctsp.giaNhap}</td>
                    <td scope="row">${ctsp.giaBan}</td>
                    <td scope="row">
                        <a class="btn btn-primary"
                           href="/Assignment_PH23038_war_exploded/chi-tiet-san-pham/edit?id=${ctsp.id}">
                            Edit
                        </a>
                        <a class="btn btn-danger"
                           href="/Assignment_PH23038_war_exploded/chi-tiet-san-pham/delete?id=${ctsp.id}">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>
    </table>
</div>

