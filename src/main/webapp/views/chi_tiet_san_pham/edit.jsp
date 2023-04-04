<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 14/03/2023
  Time: 02:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container">
    <h1 class="text-center">Chi Tiết Sản Phẩm</h1>
    <form action="/Assignment_PH23038_war_exploded/chi-tiet-san-pham/update?id=${ctsp.id}" method="post">
        <div class="row mt-3">
<%--            <div class="row mt-3">--%>
<%--                <div class="col-12">--%>
<%--                    <label class="form-label">Mã</label>--%>
<%--                    <input type="text" class="form-control" name="ma" value="${ctsp.id}" disabled/>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="col-6">
                <label class="form-label">Sản Phẩm</label>
                <select name="sanPham" class="form-select">
                    <c:forEach items="${listSanPham}" var="sp">
                        <option value="${sp.id}" ${ctsp.sanPham.id == sp.id ? "selected":""} >${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Nhà Sản Xuất</label>
                <select name="nsx" class="form-select">
                    <c:forEach items="${listNsx}" var="nsx">
                        <option value="${nsx.id}" ${ctsp.nsx.id == nsx.id ? "selected":""} >${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Màu Sắc</label>
                <select name="mauSac" class="form-select">
                    <c:forEach items="${listMauSac}" var="ms">
                        <option value="${ms.id}" ${ctsp.mauSac.id == ms.id ? "selected":""} >${ms.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Dòng Sản Phẩm</label>
                <select name="dongSp" class="form-select">
                    <c:forEach items="${listDongSanPham}" var="dongSp">
                        <option value="${dongSp.id}" ${ctsp.dongSanPham.id == dongSp.id ? "selected":""} >${dongSp.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label class="form-label">Năm Bảo Hành</label>
                <input type="text" class="form-control" name="namBaoHanh" value="${ctsp.namBaoHanh}" />
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