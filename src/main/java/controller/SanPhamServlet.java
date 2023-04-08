package controller;

import DomainModel.MauSac;
import DomainModel.NhaSanXuat;
import DomainModel.SanPham;
import Repository.SanPhamRepository;
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
import view_model.QLSanPham;

import java.io.IOException;
import java.util.Set;

@WebServlet({
        "/san-pham/create",
        "/san-pham/edit",
        "/san-pham/update",
        "/san-pham/store",
        "/san-pham/delete",
        "/san-pham/index"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo;

    public SanPhamServlet() {
        this.spRepo = new SanPhamRepository();
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
        SanPham DomainModelsp = this.spRepo.findByMa(ma);
        request.setAttribute("sp",DomainModelsp);
        request.setAttribute("view","/views/san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham DomainModelsp = this.spRepo.findByMa(ma);
        this.spRepo.delete(DomainModelsp);
        response.sendRedirect("/Assignment_PH23038_war_exploded/san-pham/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listSp",this.spRepo.findAll());
        request.setAttribute("view","/views/san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/san_pham/create.jsp");
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
            response.sendRedirect("/Assignment_PH23038_war_exploded/san-pham/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            SanPham DomainModelsp = new SanPham();
            BeanUtils.populate(DomainModelsp, request.getParameterMap());

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<SanPham>> constraintViolations = validator.validate(DomainModelsp);
            if (!constraintViolations.isEmpty()) {
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<SanPham> constraintViolation: constraintViolations) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }
                request.setAttribute("sp", DomainModelsp);
                request.setAttribute("errMa", errMa);
                request.setAttribute("errTen", errTen);
                request.setAttribute("view","/views/san_pham/create.jsp");
                request.getRequestDispatcher("/views/layout.jsp")
                        .forward(request,response);
            } else {
                this.spRepo.insert(DomainModelsp);
                request.removeAttribute("sp");
                request.removeAttribute("errMa");
                request.removeAttribute("errTen");
                response.sendRedirect("/Assignment_PH23038_war_exploded/san-pham/index");
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
            SanPham DomainModelsp = this.spRepo.findByMa(ma);
            BeanUtils.populate(DomainModelsp, request.getParameterMap());
            this.spRepo.update(DomainModelsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/san-pham/index");
    }

}
