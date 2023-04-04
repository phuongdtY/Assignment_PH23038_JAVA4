<%--
  Created by IntelliJ IDEA.
  User: homna
  Date: 21/03/2023
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Chủ</title>
<%--    <link rel="stylesheet" href="/Assignment_PH23038_war_exploded/css/bootstrap.min.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <style>
        .btn-circle {
           --bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;"
        }
    </style>
</head>
<body>
 <div class="container-fluid">

     <nav class="navbar navbar-expand-lg bg-body-tertiary">
         <div class="container-fluid">
             <a class="navbar-brand" href="#">Đặng Thanh Phương</a>
             <div class="collapse navbar-collapse" id="navbarSupportedContent">
                 <ul class="navbar-nav me-auto mb-0 mb-lg-0">
<%--                     <li class="nav-item">--%>
<%--                         <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>--%>
<%--                     </li>--%>
                     <li class="nav-item dropdown">
                         <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                             Quản lý khách hàng
                         </a>
                         <ul class="dropdown-menu">
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/khach-hang/index">khách hàng</a></li>
                         </ul>
                     </li>
                     <li class="nav-item dropdown">
                         <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                             Quản lý cửa hàng
                         </a>
                         <ul class="dropdown-menu">
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/cua-hang/index">Cửa hàng</a></li>
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/chuc-vu/index">Chức vụ</a></li>
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/nhan-vien/index">Nhân viên</a></li>
                         </ul>
                     </li>
                     <li class="nav-item dropdown">
                         <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                             Quản lý Sản Phẩm
                         </a>
                         <ul class="dropdown-menu">
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/mau-sac/index">Màu sắc</a></li>
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/san-pham/index">Sản phẩm</a></li>
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/nsx/index">Nhà sản xuất</a></li>
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/dong-san-pham/index">Dòng sản phẩm</a></li>
                             <li><a class="dropdown-item" href="/Assignment_PH23038_war_exploded/chi-tiet-san-pham/index">Chi tiết sản phẩm</a></li>
                         </ul>
                     </li>
                     <li class="nav-item">
                         <a class="nav-link active" href="/Assignment_PH23038_war_exploded/ban-hang/create"> Bán hàng</a>
                     </li>
                 </ul>
             </div>
         </div>
     </nav>

     <div class="row mt-0" style="min-height: 500px;">
         <div class="col-12 p-5">
             <jsp:include page="${ view }" />
         </div>
     </div>

     <div class="row bg-dark text-white">
             <footer class="bg-light text-center text-white">
                 <!-- Grid container -->
                 <div class="container p-4 pb-0">
                     <!-- Section: Social media -->
                     <section class="mb-4">
                         <!-- Facebook -->
                         <a
                                 class="btn btn-primary btn-circle m-1"
                                 style="background-color: #3b5998;"
                                 href="#!"
                                 role="button"
                         ><i class="fab fa-facebook-f"></i
                         ></a>
                         <!-- Twitter -->
                         <a
                                 class="btn btn-primary btn-circle m-1"
                                 style="background-color: #55acee;"
                                 href="#!"
                                 role="button"
                         ><i class="fab fa-twitter"></i
                         ></a>
                         <!-- Google -->
                         <a
                                 class="btn btn-primary btn-circle m-1"
                                 style="background-color: #dd4b39;"
                                 href="#!"
                                 role="button"
                         ><i class="fab fa-google"></i
                         ></a>

                         <!-- Instagram -->
                         <a
                                 class="btn btn-primary btn-circle m-1"
                                 style="background-color: #ac2bac;"
                                 href="#!"
                                 role="button"
                         ><i class="fab fa-instagram"></i
                         ></a>
                         <!-- Linkedin -->
                         <a
                                 class="btn btn-primary btn-circle m-1"
                                 style="background-color: #0082ca;"
                                 href="#!"
                                 role="button"
                         ><i class="fab fa-linkedin-in"></i
                         ></a>
                         <!-- Github -->
                         <a
                                 class="btn btn-primary btn-circle m-1"
                                 style="background-color: #333333;"
                                 href="#!"
                                 role="button"
                         ><i class="fab fa-github"></i
                         ></a>
                     </section>
                 </div>
                 <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                     Đặng Thanh Phương PH23038
                 </div>
             </footer>
     </div>
 </div>
<%--<script src="/Assignment_PH23038_war_exploded/js/bootstrap.min.js"></script>--%>
<%-- <script src="/Assignment_PH23038_war_exploded/js/bootstrap.bundle.min.js"></script>--%>
 <script
         src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
         integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
         crossorigin="anonymous"
 ></script>
 <script
         src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
         integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
         crossorigin="anonymous"
 ></script>
 <script src="https://kit.fontawesome.com/1dd86e46f1.js" crossorigin="anonymous"></script>
</body>
</html>
