package controller;

import DomainModel.ChucVu;
import Repository.ChucVuRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLChucVu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            ChucVu DomainModeCv = new ChucVu();
            BeanUtils.populate(DomainModeCv,request.getParameterMap());

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<ChucVu>> constraintViolations = validator.validate(DomainModeCv);
            if (!constraintViolations.isEmpty()) {
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<ChucVu> constraintViolation: constraintViolations) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }
                request.setAttribute("chucVu", DomainModeCv);
                request.setAttribute("errMa", errMa);
                request.setAttribute("errTen", errTen);
                request.setAttribute("view","/views/chuc_vu/create.jsp");
                request.getRequestDispatcher("/views/layout.jsp")
                        .forward(request,response);
            } else {
                this.cvRepo.insert(DomainModeCv);
                request.removeAttribute("chucVu");
                request.removeAttribute("errMa");
                request.removeAttribute("errTen");
                response.sendRedirect("/Assignment_PH23038_war_exploded/chuc-vu/index");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


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
