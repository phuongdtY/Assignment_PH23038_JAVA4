package controller;

import DomainModel.ChucVu;
import Repository.ChucVuRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import view_model.QLChucVu;

import java.io.IOException;

@WebServlet({
        "/chuc-vu/create",
        "/chuc-vu/edit",
        "/chuc-vu/store", //POST
        "/chuc-vu/update", //POST
        "/chuc-vu/delete",
        "/chuc-vu/index"
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo;

    public ChucVuServlet() {
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
        String ma = request.getParameter("ma");
        ChucVu DomainModeCv = this.cvRepo.findByMa(ma);
        request.setAttribute("cv",DomainModeCv);
        request.setAttribute("view","/views/chuc_vu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu DomainModeCv = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(DomainModeCv);
        response.sendRedirect("/Assignment_PH23038_war_exploded/chuc-vu/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listcv",this.cvRepo.findAll());
        request.setAttribute("view","/views/chuc_vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/chuc_vu/create.jsp");
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
            response.sendRedirect("/Assignment_PH23038_war_exploded/chuc-vu/index");
        }

    }
//    @RequestMapping(value = "/Assignment_PH23038_war_exploded/chuc-vu/create",
//            method = RequestMethod.POST)
//    public ModelAndView submit(@Valid @ModelAttribute("chucVu") ChucVu chucVu,
//                               BindingResult result) {
//
//        if (result.hasErrors()) {
//            return new ModelAndView("employeeForm");
//        }
//
//        // Lưu thông tin employee vào cơ sở dữ liệu
//        ChucVu DomainModeCv = new ChucVu();
//        this.cvRepo.insert(DomainModeCv);
//
//        return new ModelAndView("employeeSuccess");
//    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            ChucVu DomainModeCv = new ChucVu();
            BeanUtils.populate(DomainModeCv,request.getParameterMap());
            this.cvRepo.insert(DomainModeCv);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Assignment_PH23038_war_exploded/chuc-vu/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            ChucVu DomainModeCv = this.cvRepo.findByMa(ma);
            BeanUtils.populate(DomainModeCv,request.getParameterMap());
            this.cvRepo.update(DomainModeCv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/chuc-vu/index");
    }
}
