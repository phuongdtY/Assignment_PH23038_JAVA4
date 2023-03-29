
<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 13/03/2023
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container">
    <h1 class="text-center">Nhân viên</h1>
    <form action="/Assignment_PH23038_war_exploded/nhan-vien/update?ma=${nv.ma}" method="post">
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${nv.ma}" disabled/>
            </div>
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${nv.ten}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Tên đệm</label>
                <input type="text" class="form-control" name="tenDem" value="${nv.tenDem}" />
            </div>
            <div class="col-6">
                <label class="form-label">Họ</label>
                <input type="text" class="form-control" name="ho" value="${nv.ho}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Giới Tính</label>
                <div class="">
                    <input type="radio" class="form-check-inline"
                           name="gioiTinh" id="nam" value="Nam"
                           ${nv.gioiTinh == "Nam" ? "checked" : ""}
                    />
                    <label for="nam">Nam</label>
                    <input type="radio" class="form-check-inline ms-3"
                            id="nu" name="gioiTinh" value="Nữ"
                            ${nv.gioiTinh == "Nữ" ? "checked" : ""}
                    />
                    <label for="nu">Nữ</label>
                </div>
            </div>
            <div class="col-6">
                <label class="form-label">Ngày Sinh</label>
                <input type="date" class="form-control" name="ngaySinh" value="${nv.ngaySinh}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Địa Chỉ</label>
                <input type="text" class="form-control" name="diaChi" value="${nv.diaChi}" />
            </div>
            <div class="col-6">
                <label class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" name="sdt" value="${nv.sdt}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Mật khẩu</label>
                <input type="text" class="form-control" name="matKhau" value="${nv.matKhau}" />
            </div>

            <div class="col-6">
                <label class="form-label">Cửa hàng</label>
                <select name="cuaHang" class="form-select">
                    <c:forEach items="${listCuaHang}" var="ch">
                        <option value="${ch.ma}" ${nv.cuaHang.ma == ch.ma ? "selected":""}>${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Gửi báo cáo</label>
                <input type="text" class="form-control" name="idGuiBaoCao" value="${nv.idGuiBaoCao}" />
            </div>
            <div class="col-6">
                <label class="form-label">Chức vụ</label>
                <select name="chucVu" class="form-select">
                    <c:forEach items="${listChucVu}" var="cv">
                        <option value="${cv.ma}" ${nv.chucVu.ma == cv.ma ? "selected":""}>${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <label class="form-label">Trạng thái</label>
                <select name="trangThai" class="form-select">
                    <option value="0" ${nv.trangThai == "0" ? "selected":""} >Đã nghỉ</option>
                    <option value="1" ${nv.trangThai == "1" ? "selected":""} >Đang làm</option>
                </select>
            </div>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary" type="submit">Update</button>
        </div>
    </form>
</div>
