package controller;

import DomainModel.ChucVu;
import DomainModel.CuaHang;
import DomainModel.NhanVien;
import Repository.ChucVuRepository;
import Repository.CuaHangRepository;
import Repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLNhanVien;

import java.io.IOException;
import java.sql.Date;

@WebServlet({
        "/nhan-vien/create",
        "/nhan-vien/edit",
        "/nhan-vien/store", //POST
        "/nhan-vien/update", //POST
        "/nhan-vien/delete",
        "/nhan-vien/index"
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;
    private CuaHangRepository chRepo;
    private ChucVuRepository cvRepo;

    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepository();
        this.chRepo = new CuaHangRepository();
        this.cvRepo = new ChucVuRepository();
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
        request.setAttribute("listCuaHang",chRepo.findAll());
        request.setAttribute("listChucVu",cvRepo.findAll());
        String ma = request.getParameter("ma");
        NhanVien DomainModelNv = this.nvRepo.findByMa(ma);
        request.setAttribute("nv",DomainModelNv);
        request.setAttribute("view","/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien DomainModelNv = this.nvRepo.findByMa(ma);
        this.nvRepo.delete(DomainModelNv);
        response.sendRedirect("/Assignment_PH23038_war_exploded/nhan-vien/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listNv",this.nvRepo.findAll());
        request.setAttribute("view","/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listCuaHang",chRepo.findAll());
        request.setAttribute("listChucVu",cvRepo.findAll());
        request.setAttribute("view","/views/nhan_vien/create.jsp");
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
            response.sendRedirect("/Assignment_PH23038_war_exploded/nhan-vien/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLNhanVien nv = new QLNhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        NhanVien DomainModelNv = new NhanVien();
        String maCv = request.getParameter("chucVu");
        String maCh = request.getParameter("cuaHang");
        ChucVu DomainModelCv = this.cvRepo.findByMa(maCv);
        CuaHang DomainModelCh = this.chRepo.findByMa(maCh);

        DomainModelNv.setMa(nv.getMa());
        DomainModelNv.setTen(nv.getTen());
        DomainModelNv.setTenDem(nv.getTenDem());
        DomainModelNv.setHo(nv.getHo());
        DomainModelNv.setGioiTinh(nv.getGioiTinh());
        DomainModelNv.setNgaySinh( Date.valueOf(nv.getNgaySinh()));
        DomainModelNv.setDiaChi(nv.getDiaChi());
        DomainModelNv.setSdt(nv.getSdt());
        DomainModelNv.setMatKhau(nv.getMatKhau());
        DomainModelNv.setCuaHang(DomainModelCh);
        DomainModelNv.setChucVu(DomainModelCv);
        DomainModelNv.setIdGuiBaoCao(nv.getGuiBaoCao());
        DomainModelNv.setTrangThai(Integer.valueOf(nv.getTrangThai()));
        try {
            this.nvRepo.insert(DomainModelNv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/nhan-vien/index?chucVu=" + maCv + "?cuaHang=" +maCh);
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        try {
//            String ma = request.getParameter("ma");
//            NhanVien DomainModelNv = this.nvRepo.findByMa(ma);
//            BeanUtils.populate(DomainModelNv, request.getParameterMap());
//            this.nvRepo.insert(DomainModelNv);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        QLNhanVien nv = new QLNhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String ma = request.getParameter("ma");
        NhanVien DomainModelNv = this.nvRepo.findByMa(ma);
        String maCv = request.getParameter("chucVu");
        String maCh = request.getParameter("cuaHang");
        ChucVu DomainModelCv = this.cvRepo.findByMa(maCv);
        CuaHang DomainModelCh = this.chRepo.findByMa(maCh);

        DomainModelNv.setMa(nv.getMa());
        DomainModelNv.setTen(nv.getTen());
        DomainModelNv.setTenDem(nv.getTenDem());
        DomainModelNv.setHo(nv.getHo());
        DomainModelNv.setGioiTinh(nv.getGioiTinh());
        DomainModelNv.setNgaySinh( Date.valueOf(nv.getNgaySinh()));
        DomainModelNv.setDiaChi(nv.getDiaChi());
        DomainModelNv.setSdt(nv.getSdt());
        DomainModelNv.setMatKhau(nv.getMatKhau());
        DomainModelNv.setCuaHang(DomainModelCh);
        DomainModelNv.setChucVu(DomainModelCv);
        DomainModelNv.setIdGuiBaoCao(nv.getGuiBaoCao());
        DomainModelNv.setTrangThai(Integer.valueOf(nv.getTrangThai()));
        try {
            this.nvRepo.update(DomainModelNv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/nhan-vien/index");
    }

}
