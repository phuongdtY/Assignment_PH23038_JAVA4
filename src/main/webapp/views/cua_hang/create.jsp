<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 13/03/2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="container">
        <h1 class="text-center">Cửa hàng</h1>
        <form action="/Assignment_PH23038_war_exploded/cua-hang/store" method="post">
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
                <div class="col-12">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="ha_noi">Hà Nội</option>
                        <option value="new_york">New York</option>
                        <option value="tokyo">Tokyo</option>
                        <option value="paris">Paris</option>
                    </select>
                </div>
                <div class="col-6">
                    <label class="form-label">Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="vi">Việt Nam</option>
                        <option value="us">Mỹ</option>
                        <option value="jp">Nhật</option>
                        <option value="eu">Pháp</option>
                    </select>
                </div>
            </div>
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">save</button>
            </div>
        </form>
    </div>
