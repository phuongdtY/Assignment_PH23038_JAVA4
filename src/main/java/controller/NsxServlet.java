package controller;

import Repository.NsxRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLNSX;

import java.io.IOException;

@WebServlet({
        "/nsx/create",
        "/nsx/edit",
        "/nsx/store", // POST
        "/nsx/update", // POST
        "/nsx/delete",
        "/nsx/index"

})
public class NsxServlet extends HttpServlet {
    private NsxRepository nsxRepo;

    public NsxServlet() {
        this.nsxRepo = new NsxRepository();
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
        String ma = request.getParameter("maNsx");
        QLNSX nsx = this.nsxRepo.findByMa(ma);
        request.setAttribute("nsx",nsx);
        request.setAttribute("view","/views/nsx/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("maNsx");
        QLNSX nsx = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(nsx);
        response.sendRedirect("/Assignment_PH23038_war_exploded/nsx/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listNsx",this.nsxRepo.findAll());
        request.setAttribute("view","/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/nsx/create.jsp");
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
        } else if (uri.contains("update")) {
            this.update(request,response);
        } else {
            response.sendRedirect("/Assignment_PH23038_war_exploded/nsx/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLNSX qlnsx = new QLNSX();
            BeanUtils.populate(qlnsx,request.getParameterMap());
            this.nsxRepo.insert(qlnsx);
        } catch (Exception e) {
            e.printStackTrace();
        }
         response.sendRedirect("/Assignment_PH23038_war_exploded/nsx/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLNSX qlnsx = new QLNSX();
            BeanUtils.populate(qlnsx,request.getParameterMap());
            this.nsxRepo.update(qlnsx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/nsx/index");
    }

}