<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 10/03/2023
  Time: 06:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="container">
        <h1 class="text-center">Khách Hàng</h1>
        <form action="/Assignment_PH23038_war_exploded/khach-hang/store" method="POST">
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Mã</label>
                    <input type="text" name="ma" class="form-control" />
                </div>
                <div class="col-6">
                    <label class="form-label">Họ</label>
                    <input type="text" name="ho" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" name="tenDem" class="form-control" />
                </div>
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <input type="text" name="ten" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" name="ngaySinh" class="form-control" />
                </div>
                <div class="col-6">
                    <label class="form-label">Số điện thoại</label>
                    <input type="tel" name="sdt" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" name="diaChi" class="form-control" />
                </div>
                <div class="col-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" name="matKhau" class="form-control" />
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
                </div>
                <div class="col-6">
                    <label class="form-label">Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="ha_noi">Hà Nội</option>
                        <option value="new_york">New York</option>
                        <option value="tokyo">Tokyo</option>
                        <option value="paris">Paris</option>
                    </select>
                </div>
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </form>

    </div>
