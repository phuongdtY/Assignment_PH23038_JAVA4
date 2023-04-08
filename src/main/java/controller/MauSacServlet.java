package controller;

import DomainModel.DongSanPham;
import DomainModel.MauSac;
import Repository.MauSacRepository;
import Utils.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import view_model.QLMauSac;

import java.io.IOException;
import java.util.Set;

@WebServlet({
        "/mau-sac/create",
        "/mau-sac/edit",
        "/mau-sac/store", // POST
        "/mau-sac/update", // POST
        "/mau-sac/delete",
        "/mau-sac/index"

})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;

    public MauSacServlet() {
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
        String ma = request.getParameter("ma");
        MauSac DomainModelMs = this.msRepo.findByMa(ma);
        request.setAttribute("ms",DomainModelMs);
        request.setAttribute("view","/views/mau_sac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac DomainModelMs = this.msRepo.findByMa(ma);
        this.msRepo.delete(DomainModelMs);
        response.sendRedirect("/Assignment_PH23038_war_exploded/mau-sac/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listMs",this.msRepo.findAll());
        request.setAttribute("view","/views/mau_sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/mau_sac/create.jsp");
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
        } else if (uri.contains("update")){
            this.update(request,response);
        } else {
            response.sendRedirect("/Assignment_PH23038_war_exploded/mau-sac/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            MauSac DomainModelMs = new MauSac();
            BeanUtils.populate(DomainModelMs, request.getParameterMap());

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<MauSac>> constraintViolations = validator.validate(DomainModelMs);
            if (!constraintViolations.isEmpty()) {
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<MauSac> constraintViolation: constraintViolations) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }
                request.setAttribute("mausac", DomainModelMs);
                request.setAttribute("errMa", errMa);
                request.setAttribute("errTen", errTen);
                request.setAttribute("view","/views/mau_sac/create.jsp");
                request.getRequestDispatcher("/views/layout.jsp")
                        .forward(request,response);
            } else {
                this.msRepo.insert(DomainModelMs);
                request.removeAttribute("mausac");
                request.removeAttribute("errMa");
                request.removeAttribute("errTen");
                response.sendRedirect("/Assignment_PH23038_war_exploded/mau-sac/index");
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
            MauSac DomainModelMs = this.msRepo.findByMa(ma);
            BeanUtils.populate(DomainModelMs, request.getParameterMap());
            this.msRepo.update(DomainModelMs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/mau-sac/index");

    }

}
