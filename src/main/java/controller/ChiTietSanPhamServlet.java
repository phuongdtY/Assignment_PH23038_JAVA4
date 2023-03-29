package controller;

import Repository.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLChiTietSanPham;

import java.io.IOException;

@WebServlet({
        "/chi-tiet-san-pham/create",
        "/chi-tiet-san-pham/edit",
        "/chi-tiet-san-pham/update", // POST
        "/chi-tiet-san-pham/store", // POST
        "/chi-tiet-san-pham/delete",
        "/chi-tiet-san-pham/index"
})
public class ChiTietSanPhamServlet extends HttpServlet {

    private ChiTietSanPhamRepository ctspRepo;

    public  ChiTietSanPhamServlet() {
        this.ctspRepo = new ChiTietSanPhamRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")){
            this.create(request,response);
        } else if (uri.contains("edit")){
            this.edit(request,response);
        } else if (uri.contains("delete")){
            this.delete(request,response);
        } else {
            this.index(request,response);
        }
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChiTietSanPham ctsp = this.ctspRepo.findByMa(ma);
        request.setAttribute("ctsp",ctsp);
        request.setAttribute("view","/views/chi_tiet_san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChiTietSanPham ctsp = this.ctspRepo.findByMa(ma);
        this.ctspRepo.delete(ctsp);
        response.sendRedirect("/Assignment_PH23038_war_exploded/chi-tiet-san-pham/index");
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listSanPham",new SanPhamRepository().findAll());
        request.setAttribute("listNsx",new NsxRepository().findAll());
        request.setAttribute("listMauSac",new MauSacRepository().findAll());
        request.setAttribute("listDongSanPham",new DongSpRepository().findAll());
        request.setAttribute("view","/views/chi_tiet_san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listctsp",this.ctspRepo.finAll());
        request.setAttribute("view","/views/chi_tiet_san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request,response);
        } else if (uri.contains("update")) {
            this.update(request,response);
        } else {
            response.sendRedirect("/Assignment_PH23038_war_exploded/chi-tiet-san-pham/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            QLChiTietSanPham qlctsp = new QLChiTietSanPham();
            BeanUtils.populate(qlctsp, request.getParameterMap());
            this.ctspRepo.insert(qlctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/chi-tiet-san-pham/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            QLChiTietSanPham qlctsp = new QLChiTietSanPham();
            BeanUtils.populate(qlctsp, request.getParameterMap());
            this.ctspRepo.update(qlctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/chi-tiet-san-pham/index");
    }
}
