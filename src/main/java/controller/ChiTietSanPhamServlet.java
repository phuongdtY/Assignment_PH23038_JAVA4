package controller;

import DomainModel.*;
import Repository.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLChiTietSanPham;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

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
    private SanPhamRepository sanPhamRepo;
    private DongSpRepository dongSpRepo;
    private NsxRepository nsxRepo;
    private MauSacRepository msRepo;

    public  ChiTietSanPhamServlet() {
        this.ctspRepo = new ChiTietSanPhamRepository();
        this.sanPhamRepo = new SanPhamRepository();
        this.dongSpRepo = new DongSpRepository();
        this.nsxRepo = new NsxRepository();
        this.msRepo = new MauSacRepository();
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
        String idStr = request.getParameter("id");
//        UUID id = UUID.fromString(idStr);
        ChiTietSanPham DomainModelctsp = this.ctspRepo.findById(idStr);
        request.setAttribute("listSanPham",sanPhamRepo.findAll());
        request.setAttribute("listNsx",nsxRepo.findAll());
        request.setAttribute("listMauSac",msRepo.findAll());
        request.setAttribute("listDongSanPham",dongSpRepo.findAll());
        request.setAttribute("ctsp",DomainModelctsp);
        request.setAttribute("view","/views/chi_tiet_san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String idStr = request.getParameter("id");
//        UUID id = UUID.fromString(idStr);
        ChiTietSanPham DomainModelctsp = this.ctspRepo.findById(idStr);
        this.ctspRepo.delete(DomainModelctsp);
        response.sendRedirect("/Assignment_PH23038_war_exploded/chi-tiet-san-pham/index");
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listSanPham",sanPhamRepo.findAll());
        request.setAttribute("listNsx",nsxRepo.findAll());
        request.setAttribute("listMauSac",msRepo.findAll());
        request.setAttribute("listDongSanPham",dongSpRepo.findAll());
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
        QLChiTietSanPham ctsp = new QLChiTietSanPham();
        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChiTietSanPham DomainModelctsp = new ChiTietSanPham();

        String idSp = request.getParameter("sanPham");
        String idDongSp = request.getParameter("dongSp");
        String idNsx = request.getParameter("nsx");
        String idMs = request.getParameter("mauSac");

        NhaSanXuat nsx = this.nsxRepo.findById(idNsx);
        MauSac mauSac = this.msRepo.findById(idMs);
        DongSanPham dongSanPham = this.dongSpRepo.findById(idDongSp);
        SanPham sanPham = this.sanPhamRepo.findById(idSp);

        DomainModelctsp.setSanPham(sanPham);
        DomainModelctsp.setNsx(nsx);
        DomainModelctsp.setMauSac(mauSac);
        DomainModelctsp.setDongSanPham(dongSanPham);
        DomainModelctsp.setNamBaoHanh(Integer.valueOf(ctsp.getNamBaoHanh()));
        DomainModelctsp.setMoTa(ctsp.getMoTa());
        DomainModelctsp.setSoLuongTon(Integer.valueOf(ctsp.getSoLuongTon()));
        DomainModelctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(ctsp.getGiaNhap())));
        DomainModelctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(ctsp.getGiaBan())));
        try {
            this.ctspRepo.insert(DomainModelctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/chi-tiet-san-pham/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        QLChiTietSanPham ctsp = new QLChiTietSanPham();
        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idStr = request.getParameter("id");
//        UUID id = UUID.fromString(idStr);
        ChiTietSanPham DomainModelctsp = this.ctspRepo.findById(idStr);

        String idSp = request.getParameter("sanPham");
        String idDongSp = request.getParameter("dongSp");
        String idNsx = request.getParameter("nsx");
        String idMs = request.getParameter("mauSac");

        NhaSanXuat nsx = this.nsxRepo.findById(idNsx);
        MauSac mauSac = this.msRepo.findById(idMs);
        DongSanPham dongSanPham = this.dongSpRepo.findById(idDongSp);
        SanPham sanPham = this.sanPhamRepo.findById(idSp);

        DomainModelctsp.setSanPham(sanPham);
        DomainModelctsp.setNsx(nsx);
        DomainModelctsp.setMauSac(mauSac);
        DomainModelctsp.setDongSanPham(dongSanPham);
        DomainModelctsp.setNamBaoHanh(Integer.valueOf(ctsp.getNamBaoHanh()));
        DomainModelctsp.setMoTa(ctsp.getMoTa());
        DomainModelctsp.setSoLuongTon(Integer.valueOf(ctsp.getSoLuongTon()));
        DomainModelctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(ctsp.getGiaNhap())));
        DomainModelctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(ctsp.getGiaBan())));
        try {
            this.ctspRepo.update(DomainModelctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/chi-tiet-san-pham/index");
    }
}
