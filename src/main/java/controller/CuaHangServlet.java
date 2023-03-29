package controller;

import DomainModel.CuaHang;
import Repository.CuaHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLCuaHang;

import java.io.IOException;

@WebServlet({
        "/cua-hang/create",
        "/cua-hang/edit",
        "/cua-hang/store", //POST
        "/cua-hang/update", //POST
        "/cua-hang/delete",
        "/cua-hang/index"
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepo;

    public CuaHangServlet() {
        this.cuaHangRepo = new CuaHangRepository();
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
        String maCh = request.getParameter("maCh");
        CuaHang DomainModelCh = this.cuaHangRepo.findByMa(maCh);
        request.setAttribute("ch",DomainModelCh);
        request.setAttribute("view","/views/cua_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String maCh = request.getParameter("maCh");
        CuaHang DomainModelCh = this.cuaHangRepo.findByMa(maCh);
        this.cuaHangRepo.delete(DomainModelCh);
        response.sendRedirect("/Assignment_PH23038_war_exploded/cua-hang/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listCh",cuaHangRepo.findAll());
        request.setAttribute("view","/views/cua_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/cua_hang/create.jsp");
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
            response.sendRedirect("/Assignment_PH23038_war_exploded/cua-hang/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            CuaHang DomainModelCh = new CuaHang();
            BeanUtils.populate(DomainModelCh, request.getParameterMap());
            cuaHangRepo.insert(DomainModelCh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/cua-hang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            CuaHang DomainModelCh = this.cuaHangRepo.findByMa(ma);
            BeanUtils.populate(DomainModelCh, request.getParameterMap());
            cuaHangRepo.update(DomainModelCh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/cua-hang/index");
    }

}
