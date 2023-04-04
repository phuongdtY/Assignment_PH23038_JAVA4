<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 11/03/2023
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    <div class="table-responsive">
        <div class="form-label text-center h1"> Khách Hàng</div>
        <a class="btn btn-primary " href="/Assignment_PH23038_war_exploded/khach-hang/create">Add</a>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Họ và tên</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col">Số điện thoại</th>
                    <th scope="col">Mật khẩu</th>
                    <th scope="col">Thành phố</th>
                    <th scope="col">Quốc gia</th>
                    <th scope="col">Ngày sinh</th>
                    <th scope="col">Thao tác</th>
                </tr>
            </thead>
            <c:if test="${f:length(list) == 0}">
                <h3 class="alert-warning">Không có dữ liệu</h3>
            </c:if>
            <c:if test="${f:length(list) != 0}">
                <tbody>
                <c:forEach items="${list}" var="kh">
                    <tr class="">
                        <td scope="row">${kh.ma} </td>
                        <td scope="row">${kh.ho} ${kh.tenDem} ${kh.ten}</td>
                        <td scope="row">${kh.diaChi}</td>
                        <td scope="row">${kh.sdt}</td>
                        <td scope="row">${kh.matKhau}</td>
                        <td scope="row">${kh.thanhPho}</td>
                        <td scope="row">${kh.quocGia}</td>
                        <td scope="row">${kh.ngaySinh}</td>
                        <td scope="row">
                            <a class="btn btn-primary"
                               href="/Assignment_PH23038_war_exploded/khach-hang/edit?makh=${kh.ma}">
                                Edit
                            </a>
                            <a class="btn btn-danger"
                                href="/Assignment_PH23038_war_exploded/khach-hang/delete?makh=${kh.ma}" >
                                Delete
                            </a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </c:if>
        </table>
    </div>
