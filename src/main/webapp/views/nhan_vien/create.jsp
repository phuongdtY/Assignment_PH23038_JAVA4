<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h1 class="text-center">Nhân viên</h1>
    <form action="/Assignment_PH23038_war_exploded/nhan-vien/store" method="post">
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" />
            </div>

            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" />
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Tên đệm</label>
                <input type="text" class="form-control" name="tenDem" />
            </div>
            <div class="col-6">
                <label class="form-label">Họ</label>
                <input type="text" class="form-control" name="ho" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Giới Tính</label>
                <div class="">
                    <input type="radio" class="form-check-inline"
                           name="gioiTinh" id="nam" checked value="Nam"
                    />
                    <label for="nam">Nam</label>
                    <input type="radio" class="form-check-inline ms-3"
                            id="nu" name="gioiTinh" value="Nữ"
                    />
                    <label for="nu">Nữ</label>
                </div>
            </div>
            <div class="col-6">
                <label class="form-label">Ngày Sinh</label>
                <input type="date" class="form-control" name="ngaySinh" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Địa Chỉ</label>
                <input type="text" class="form-control" name="diaChi" />
            </div>
            <div class="col-6">
                <label class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" name="sdt" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Mật khẩu</label>
                <input type="text" class="form-control" name="matKhau" />
            </div>
            <div class="col-6">
                <label class="form-label">Cửa hàng</label>
                <select name="cuaHang" class="form-select">
                    <c:forEach items="${listCuaHang}" var="ch">
                        <option value="${ch.id}">${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Gửi báo cáo</label>
                <input type="text" class="form-control" name="idGuiBaoCao" />
            </div>
            <div class="col-6">
                <label class="form-label">Chức vụ</label>
                <select name="chucVu" class="form-select">
                    <c:forEach items="${listChucVu}" var="cv">
                        <option value="${cv.id}">${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <label class="form-label">Trạng thái</label>
                <select name="trangThai" class="form-select">
                    <option value="0">Đã nghỉ</option>
                    <option value="1">Đang làm</option>
                </select>
            </div>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary" type="submit">save</button>
        </div>
    </form>
</div>
