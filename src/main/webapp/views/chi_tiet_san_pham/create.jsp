<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="/Assignment_PH23038_war_exploded/chi-tiet-san-pham/store" method="post">
        <div class="row mt-3">
            <div class="col-12">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Sản Phẩm</label>
                <select name="sanPham" class="form-select">
                    <c:forEach items="${listSanPham}" var="sp">
                        <option value="${sp.ma}">${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Nhà Sản Xuất</label>
                <select name="nsx" class="form-select">
                    <c:forEach items="${listNsx}" var="nsx">
                        <option value="${nsx.ma}">${nsx.ten}</option>
                    </c:forEach>
<%--                    <option value="vi">Việt Nam</option>--%>
<%--                    <option value="us">Mỹ</option>--%>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Màu Sắc</label>
                <select name="mauSac" class="form-select">
                    <c:forEach items="${listMauSac}" var="ms">
                        <option value="${ms.ma}">${ms.ten}</option>
                    </c:forEach>
<%--                    <option value="red">đỏ</option>--%>
<%--                    <option value="bule">xanh</option>--%>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Dòng Sản Phẩm</label>
                <select name="dongSp" class="form-select">
                    <c:forEach items="${listDongSanPham}" var="dongSp">
                        <option value="${dongSp.ma}">${dongSp.ten}</option>
                    </c:forEach>
<%--                    <option value="A">Loại A</option>--%>
<%--                    <option value="B">Loại B</option>--%>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Năm Bảo Hành</label>
                <input type="text" class="form-control" name="namBh" />
            </div>
            <div class="col-6">
                <label class="form-label">Mô tả</label>
                <input type="text" class="form-control" name="moTa" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <label class="form-label">Số lượng tồn</label>
                <input type="text" class="form-control" name="soLuongTon" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Giá nhập</label>
                <input type="text" class="form-control" name="giaNhap" />
            </div>
            <div class="col-6">
                <label class="form-label">Giá bán</label>
                <input type="text" class="form-control" name="giaBan" />
            </div>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary" type="submit">save</button>
        </div>
    </form>
</div>
