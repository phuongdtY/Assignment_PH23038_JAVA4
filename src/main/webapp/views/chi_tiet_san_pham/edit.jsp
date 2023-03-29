<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 14/03/2023
  Time: 02:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h1 class="text-center">Chi Tiết Sản Phẩm</h1>
    <form action="/Assignment_PH23038_war_exploded/chi-tiet-san-pham/update?ma=${ctsp.ma}" method="post">
        <div class="row mt-3">
            <div class="row mt-3">
                <div class="col-12">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" value="${ctsp.ma}" disabled/>
                </div>
            </div>
            <div class="col-6">
                <label class="form-label">Sản Phẩm</label>
                <select name="sanPham" class="form-select">
                    <option value="product_1" ${ctsp.sanPham == "product_1" ? "selected":""}>Sản Phẩm 1</option>
                    <option value="product_2" ${ctsp.sanPham == "product_2" ? "selected":""}>Sản Phẩm 2</option>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Nhà Sản Xuất</label>
                <select name="nsx" class="form-select">
                    <option value="vi" ${ctsp.nsx == "vi" ? "selected":""}>Việt Nam</option>
                    <option value="us" ${ctsp.nsx == "us" ? "selected":""}>Mỹ</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Màu Sắc</label>
                <select name="mauSac" class="form-select">
                    <option value="red" ${ctsp.mauSac == "red" ? "selected":""}>đỏ</option>
                    <option value="blue" ${ctsp.mauSac == "blue" ? "selected":""}>xanh</option>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Dòng Sản Phẩm</label>
                <select name="dongSp" class="form-select">
                    <option value="A" ${ctsp.dongSp == "A" ? "selected":""}>Loại A</option>
                    <option value="B" ${ctsp.dongSp == "B" ? "selected":""}>Loại B</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Năm Bảo Hành</label>
                <input type="text" class="form-control" name="namBh" value="${ctsp.namBh}" />
            </div>
            <div class="col-6">
                <label class="form-label">Mô tả</label>
                <input type="text" class="form-control" name="moTa" value="${ctsp.moTa}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <label class="form-label">Số lượng tồn</label>
                <input type="text" class="form-control" name="soLuongTon" value="${ctsp.soLuongTon}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Giá nhập</label>
                <input type="text" class="form-control" name="giaNhap"  value="${ctsp.giaNhap}" />
            </div>
            <div class="col-6">
                <label class="form-label">Giá bán</label>
                <input type="text" class="form-control" name="giaBan" value="${ctsp.giaBan}" />
            </div>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary" type="submit">Update</button>
        </div>
    </form>
</div>