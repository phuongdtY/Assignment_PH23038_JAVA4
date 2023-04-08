package controller;

import DomainModel.CuaHang;
import DomainModel.DongSanPham;
import Repository.CuaHangRepository;
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
import view_model.QLCuaHang;

import java.io.IOException;
import java.util.Set;

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

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<CuaHang>> constraintViolations = validator.validate(DomainModelCh);
            if (!constraintViolations.isEmpty()) {
                String errMa = "";
                String errTen = "";
                String errdiaChi = "";
                String errthanhPho = "";
                String errquocGia = "";
                for (ConstraintViolation<CuaHang> constraintViolation: constraintViolations) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else if (constraintViolation.getPropertyPath().toString().equals("ten")) {
                        errTen = constraintViolation.getMessage();
                    } else if (constraintViolation.getPropertyPath().toString().equals("diaChi")) {
                        errdiaChi  = constraintViolation.getMessage();
                    }else if (constraintViolation.getPropertyPath().toString().equals("thanhPho")) {
                        errthanhPho = constraintViolation.getMessage();
                    }else if (constraintViolation.getPropertyPath().toString().equals("quocGia")) {
                        errquocGia  = constraintViolation.getMessage();
                    }
                }
                request.setAttribute("ch", DomainModelCh);
                request.setAttribute("errMa", errMa);
                request.setAttribute("errTen", errTen);
                request.setAttribute("errdiaChi", errdiaChi);
                request.setAttribute("errthanhPho", errthanhPho);
                request.setAttribute("errquocGia", errquocGia);
                request.setAttribute("view","/views/cua_hang/create.jsp");
                request.getRequestDispatcher("/views/layout.jsp")
                        .forward(request,response);
            } else {
                this.cuaHangRepo.insert(DomainModelCh);
                request.removeAttribute("ch");
                request.removeAttribute("errMa");
                request.removeAttribute("errTen");
                request.removeAttribute("errdiaChi");
                request.removeAttribute("errthanhPho");
                request.removeAttribute("errquocGia");
                response.sendRedirect("/Assignment_PH23038_war_exploded/cua-hang/index");
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
            CuaHang DomainModelCh = this.cuaHangRepo.findByMa(ma);
            BeanUtils.populate(DomainModelCh, request.getParameterMap());
            cuaHangRepo.update(DomainModelCh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_PH23038_war_exploded/cua-hang/index");
    }

}
