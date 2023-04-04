<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 15/03/2023
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="table-responsive">
    <div class="form-label text-center h1"> Nhân Viên</div>
    <a class="btn btn-primary " href="/Assignment_PH23038_war_exploded/nhan-vien/create">Add</a>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Họ và Tên</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Số điện thoại </th>
            <th scope="col">Cửa hàng</th>
            <th scope="col">Chức vụ</th>
            <th scope="col">Gửi báo cáo</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <c:if test="${f:length(listNv) == 0}">
            <h3 class="alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${f:length(listNv) != 0}">
            <tbody>
            <c:forEach items="${listNv}" var="nv">
                <tr class="">
                    <td scope="row">${nv.ma} </td>
                    <td scope="row">${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                    <td scope="row">${nv.gioiTinh}</td>
                    <td scope="row">${nv.ngaySinh}</td>
                    <td scope="row">${nv.diaChi}</td>
                    <td scope="row">${nv.sdt}</td>
                    <td scope="row">${nv.cuaHang.ten}</td>
                    <td scope="row">${nv.chucVu.ten}</td>
                    <td scope="row">${nv.idGuiBaoCao}</td>
                    <td scope="row">${nv.trangThai == 0 ? "Đã nghỉ":"Đang làm"}</td>
                    <td scope="row">
                        <a class="btn btn-primary" href="/Assignment_PH23038_war_exploded/nhan-vien/edit?id=${nv.id}">
                            Edit
                        </a>
                        <a class="btn btn-danger" href="/Assignment_PH23038_war_exploded/nhan-vien/delete?id=${nv.id}">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>
    </table>
</div>
