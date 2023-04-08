<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 13/03/2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    <div class="container">
        <h1 class="text-center">Cửa hàng</h1>
        <form action="/Assignment_PH23038_war_exploded/cua-hang/store" method="post">
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" value="${ch.ma}" />
                    <c:if test="${not empty errMa}">
                        <div class="alert alert-danger">${errMa}</div>
                    </c:if>
                </div>
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" value="${ch.ten}" />
                    <c:if test="${not empty errTen}">
                        <div class="alert alert-danger">${errTen}</div>
                    </c:if>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" value="${ch.diaChi}" />
                    <c:if test="${not empty errdiaChi}">
                        <div class="alert alert-danger">${errdiaChi}</div>
                    </c:if>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label class="form-label">Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="ha_noi" ${ch.thanhPho == "ha_noi" ? "selected":""}>Hà Nội</option>
                        <option value="new_york" ${ch.thanhPho == "new_york" ? "selected":""}>New York</option>
                        <option value="tokyo" ${ch.thanhPho == "tokyo" ? "selected":""}>Tokyo</option>
                        <option value="paris" ${ch.thanhPho == "paris" ? "selected":""}>Paris</option>
                    </select>
                    <c:if test="${not empty errthanhPho}">
                        <div class="alert alert-danger">${errthanhPho}</div>
                    </c:if>
                </div>
                <div class="col-6">
                    <label class="form-label">Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="vi" ${ch.quocGia == "vi" ? "selected":""} >Việt Nam</option>
                        <option value="us" ${ch.quocGia == "us" ? "selected":""} >Mỹ</option>
                        <option value="jp" ${ch.quocGia == "jp" ? "selected":""} >Nhật</option>
                        <option value="eu" ${ch.quocGia == "eu" ? "selected":""} >Pháp</option>
                    </select>
                    <c:if test="${not empty errquocGia}">
                        <div class="alert alert-danger">${errquocGia}</div>
                    </c:if>
                </div>
            </div>
            <div class="mt-3">
                <button class="btn btn-primary" type="submit">save</button>
            </div>
        </form>
    </div>
