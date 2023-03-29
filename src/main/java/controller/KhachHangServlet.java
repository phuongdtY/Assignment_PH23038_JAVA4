package controller;

import DomainModel.KhachHang;
import Repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({
        "/khach-hang/index", //GET
        "/khach-hang/create", //GET
        "/khach-hang/store", //POST
        "/khach-hang/edit", //GET
        "/khach-hang/update", //POST
        "/khach-hang/delete", //GET
})

public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    public KhachHangServlet(){
        this.khRepo = new KhachHangRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")){
            this.create(req,resp);
        } else if (uri.contains("edit")){
            this.edit(req,resp);
        } else if (uri.contains("delete")){
            this.delete(req,resp);
        } else {
            this.index(req,resp);
        }

    }

    protected void edit(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String ma = req.getParameter("makh");
        KhachHang Domainkh = this.khRepo.findByMa(ma);
        req.setAttribute("kh",Domainkh);
        req.setAttribute("view","/views/khach_hang/edit.jsp");
        req.getRequestDispatcher("/views/layout.jsp")
                .forward(req,resp);
    }

    protected void delete(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String ma = req.getParameter("makh");
        KhachHang Domainkh = this.khRepo.findByMa(ma);
        this.khRepo.delete(Domainkh);
        resp.sendRedirect("/Assignment_PH23038_war_exploded/khach-hang/index");
    }


    protected void create(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.setAttribute("view","/views/khach_hang/create.jsp");
        req.getRequestDispatcher("/views/layout.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")){
            this.store(req,resp);
        } else if (uri.contains("update")){
            this.update(req,resp);
        } else {
            resp.sendRedirect("/Assignment_PH23038_war_exploded/khach-hang/index");
        }
    }

    protected void index(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.setAttribute("list",this.khRepo.findAll());
        req.setAttribute("view","/views/khach_hang/index.jsp");
        req.getRequestDispatcher("/views/layout.jsp")
                .forward(req,resp);
    }

    protected void store(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        try {
            KhachHang Domainkh = new KhachHang();
            BeanUtils.populate(Domainkh, req.getParameterMap());
            System.out.println(Domainkh.getMa());
            khRepo.insert(Domainkh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Assignment_PH23038_war_exploded/khach-hang/index");
    }

    protected void update(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        try {
            String ma = req.getParameter("ma");
            KhachHang Domainkh = khRepo.findByMa(ma);
            BeanUtils.populate(Domainkh, req.getParameterMap());
            khRepo.update(Domainkh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Assignment_PH23038_war_exploded/khach-hang/index");
    }

}
