package controller;

import DomainModel.KhachHang;
import Repository.KhachHangRepository;
import Repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/ban-hang/create",
        "/ban-hang/edit",
        "/ban-hang/update", // POST
        "/ban-hang/store", // POST
        "/ban-hang/delete",
        "/ban-hang/index"
})
public class BanHangServlet extends HttpServlet {

    private NhanVienRepository nvRepo;
    private KhachHangRepository khRepo;

    public BanHangServlet(){
        this.nvRepo = new NhanVienRepository();
        this.khRepo = new KhachHangRepository();
    }

    @Override
    protected void doGet
            (HttpServletRequest request,
             HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")){
            this.create(request,response);
        } else if (uri.contains("edit")){
//            this.edit(request,response);
        } else if (uri.contains("delete")){
//            this.delete(request,response);
        } else {
//            this.index(request,response);
        }
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listKhachHang",this.khRepo.findAll());
        request.setAttribute("view","/views/BanHang/BanHang.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

    }
}
