package controller;

import DomainModel.DongSanPham;
import Repository.DongSpRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLDongSP;

import java.io.IOException;

@WebServlet({
        "/dong-san-pham/create",
        "/dong-san-pham/edit",
        "/dong-san-pham/update", // POST
        "/dong-san-pham/store", // POST
        "/dong-san-pham/delete",
        "/dong-san-pham/index"
})
public class DongSanPhamServlet extends HttpServlet {
    private DongSpRepository dongSpRepo;

    public DongSanPhamServlet() {
        this.dongSpRepo = new DongSpRepository();
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
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listdongSp",this.dongSpRepo.findAll());
        request.setAttribute("view","/views/dong_san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSanPham DomainModeldongSP = this.dongSpRepo.findByMa(ma);
        request.setAttribute("dongSp",DomainModeldongSP);
        request.setAttribute("view","/views/dong_san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSanPham DomainModeldongSP = this.dongSpRepo.findByMa(ma);
        this.dongSpRepo.delete(DomainModeldongSP);
        response.sendRedirect("/Assignment_PH23038_war_exploded/dong-san-pham/index");
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/dong_san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")){
            this.store(request,response);
        } else if (uri.contains("update")){
            this.update(request,response);
        } else {
            response.sendRedirect("/Assignment_PH23038_war_exploded/dong-san-pham/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            DongSanPham DomainModeldongSP = new DongSanPham();
            BeanUtils.populate(DomainModeldongSP,request.getParameterMap());
            this.dongSpRepo.insert(DomainModeldongSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/dong-san-pham/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            String ma = request.getParameter("ma");
            DongSanPham DomainModeldongSP = this.dongSpRepo.findByMa(ma);
            BeanUtils.populate(DomainModeldongSP,request.getParameterMap());
            this.dongSpRepo.update(DomainModeldongSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/dong-san-pham/index");
    }

}
