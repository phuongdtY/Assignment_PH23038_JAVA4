<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 01/04/2023
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container m-0">
    <div class="form-label text-center h1"> Bán hàng</div>
    <div class="row">
        <div class="col-8">
            <div class="form-label h4"> Hóa đơn</div>
            <div class="row">
                <!-- lọc -->
                <div class="col-12">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="trangThai" id="tat_ca"
                               value="0" checked>
                        <label class="form-check-label" for="tat_ca">Tất cả</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="trangThai"
                               id="da_thanh_toan"
                               value="1">
                        <label class="form-check-label" for="da_thanh_toan">Đã thanh toán</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="trangThai" id="chua_thanh_toan"
                               value="2">
                        <label class="form-check-label" for="chua_thanh_toan">Chưa thanh toán</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="trangThai" id="Da_huy"
                               value="3">
                        <label class="form-check-label" for="Da_huy">Đã hủy</label>
                    </div>
                </div>
                <!-- table hóa đơn -->
                <div class="col-12">
                    <div class="table-responsive" style="height: 150px;">
                        <table class="table table-dark">
                            <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Mã HĐ</th>
                                <th scope="col">Ngày Tạo</th>
                                <th scope="col">Tên NV</th>
                                <th scope="col">Tình trạng</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="">
                                <td scope="row">1</td>
                                <td scope="row">HĐ01</td>
                                <td scope="row">2023-04-03</td>
                                <td scope="row">Thanh Phương</td>
                                <td scope="row">Đạng làm</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="form-label h4"> Giỏ hàng</div>
            <div class="row">
                <!-- table giỏ hàng  -->
                <div class="col-12">
                    <div class="table-responsive" style="height: 200px;">
                        <table class="table table-dark">
                            <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Mã SP</th>
                                <th scope="col">Tên SP</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col">Đơn giá</th>
                                <th scope="col">Thành tiền</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="">
                                <td scope="row">1</td>
                                <td scope="row">SP01</td>
                                <td scope="row">giầy nike</td>
                                <td scope="row">1</td>
                                <td scope="row">25000.0</td>
                                <td scope="row">25000.0</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="form-label h4"> Sản phẩm</div>
            <div class="row">
                <!-- table Sản phẩm  -->
                <div class="col-12">
                    <div class="table-responsive" style="height: 200px;">
                        <table class="table table-dark">
                            <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Mã SP</th>
                                <th scope="col">Tên SP</th>
                                <th scope="col">Năm bảo hành</th>
                                <th scope="col">Số lượng SP</th>
                                <th scope="col">Giá nhập</th>
                                <th scope="col">Giá bán</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="">
                                <td scope="row">1</td>
                                <td scope="row">SP01</td>
                                <td scope="row">giầy nike</td>
                                <td scope="row">3</td>
                                <td scope="row">20</td>
                                <td scope="row">15000.0</td>
                                <td scope="row">25000.0</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-4">
            <div class="row">
                <div class="col-12">
                    <div class="mb-3">
                        <label class="form-label h5">Khách hàng</label>
                        <select class="form-select form-select-lg" name="khachHang" >
                            <option value="null" selected>Khách hàng lẻ</option>
                            <c:forEach items="${listKhachHang}" var="kh">
                                <option value="${kh.id}">${kh.ho} ${kh.tenDem} ${kh.ten} / ${kh.ma}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3 text-center">
                        <a type="button" class="btn btn-primary">Tạo Hóa Đơn</a>
                    </div>
                </div>
            </div>
            <div class="row mt-2">
                <label class="form-label text-center h5">Hóa Đơn</label>
                <div class="mb-3">
                    <label class="form-label h6">Mã hóa đơn</label>
                    <input type="text" class="form-control" name=""  disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label h6">Ngày tạo</label>
                    <input type="date" class="form-control" name="" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label h6">Tên nhân viên</label>
                    <input type="text" class="form-control" name="" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label h6">Tên khách hàng</label>
                    <input type="text" class="form-control" name="" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label h6">Tổng tiền</label>
                    <input type="text" class="form-control" name="" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label h6">Tiền khách đưa</label>
                    <input type="text" class="form-control" name="" >
                </div>
                <div class="mb-3">
                    <label class="form-label h6">Tiền thừa</label>
                    <input type="text" class="form-control" name="" disabled>
                </div>
                <div class="mb-3 text-center">
                    <a type="button" class="btn btn-primary">Thanh toán</a>
                </div>
            </div>
        </div>
    </div>
</div>
