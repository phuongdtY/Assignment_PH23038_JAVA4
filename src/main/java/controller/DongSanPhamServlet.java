package controller;

import DomainModel.ChucVu;
import DomainModel.DongSanPham;
import Repository.DongSpRepository;
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
import view_model.QLDongSP;

import java.io.IOException;
import java.util.Set;

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

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<DongSanPham>> constraintViolations = validator.validate(DomainModeldongSP);
            if (!constraintViolations.isEmpty()) {
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<DongSanPham> constraintViolation: constraintViolations) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }
                request.setAttribute("dongSanPham", DomainModeldongSP);
                request.setAttribute("errMa", errMa);
                request.setAttribute("errTen", errTen);
                request.setAttribute("view","/views/dong_san_pham/create.jsp");
                request.getRequestDispatcher("/views/layout.jsp")
                        .forward(request,response);
            } else {
                this.dongSpRepo.insert(DomainModeldongSP);
                request.removeAttribute("dongSanPham");
                request.removeAttribute("errMa");
                request.removeAttribute("errTen");
                response.sendRedirect("/Assignment_PH23038_war_exploded/dong-san-pham/index");
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
            DongSanPham DomainModeldongSP = this.dongSpRepo.findByMa(ma);
            BeanUtils.populate(DomainModeldongSP,request.getParameterMap());
            this.dongSpRepo.update(DomainModeldongSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/dong-san-pham/index");
    }

}
