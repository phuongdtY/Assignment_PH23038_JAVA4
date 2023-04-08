<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 10/03/2023
  Time: 06:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    <div class="container">
        <h1 class="text-center">Khách Hàng</h1>
        <form action="/Assignment_PH23038_war_exploded/khach-hang/store" method="POST">
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Mã</label>
                    <input type="text" name="ma" class="form-control" value="${kh.ma}" />
                    <c:if test="${not empty errMa}">
                        <div class="alert alert-danger">${errMa}</div>
                </c:if>
                </div>
                <div class="col-6">
                    <label class="form-label">Họ</label>
                    <input type="text" name="ho" class="form-control" value="${kh.ho}"/>
                    <c:if test="${not empty errHo}">
                        <div class="alert alert-danger">${errHo}</div>
                </c:if>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" name="tenDem" class="form-control" value="${kh.tenDem}" />
                    <c:if test="${not empty errTenDem}">
                        <div class="alert alert-danger">${errTenDem}</div>
                </c:if>
                </div>
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <input type="text" name="ten" class="form-control" value="${kh.ten}" />
                    <c:if test="${not empty errTen}">
                        <div class="alert alert-danger">${errTen}</div>
                </c:if>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" name="ngaySinh" class="form-control" value="${kh.ngaySinh}" />
                    <c:if test="${not empty errNgaySinh}">
                        <div class="alert alert-danger">${errNgaySinh}</div>
                </c:if>
                </div>
                <div class="col-6">
                    <label class="form-label">Số điện thoại</label>
                    <input type="tel" name="sdt" class="form-control" value="${kh.sdt}" />
                    <c:if test="${not empty errSdt}">
                        <div class="alert alert-danger">${errSdt}</div>
                </c:if>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" name="diaChi" class="form-control" value="${kh.diaChi}" />
                    <c:if test="${not empty errdiaChi}">
                        <div class="alert alert-danger">${errdiaChi}</div>
                </c:if>
                </div>
                <div class="col-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" name="matKhau" class="form-control" value="${kh.matKhau}" />
                    <c:if test="${not empty errMatKhau}">
                        <div class="alert alert-danger">${errMatKhau}</div>
                </c:if>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="vi">Việt Nam</option>
                        <option value="us">Mỹ</option>
                        <option value="jp">Nhật</option>
                        <option value="eu">Pháp</option>
                    </select>
                    <c:if test="${not empty errquocGia}">
                        <div class="alert alert-danger">${errquocGia}</div>
                </c:if>
                </div>
                <div class="col-6">
                    <label class="form-label">Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="ha_noi">Hà Nội</option>
                        <option value="new_york">New York</option>
                        <option value="tokyo">Tokyo</option>
                        <option value="paris">Paris</option>
                    </select>
                    <c:if test="${not empty errthanhPho}">
                        <div class="alert alert-danger">${errthanhPho}</div>
                </c:if>
                </div>
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </form>

    </div>
