package controller;

import DomainModel.CuaHang;
import DomainModel.KhachHang;
import Repository.KhachHangRepository;
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
import view_model.QLKhachHang;

import java.io.IOException;
import java.sql.Date;
import java.util.Set;

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
        QLKhachHang qlkh = new QLKhachHang();
        try {
            BeanUtils.populate(qlkh, req.getParameterMap());
        } catch (Exception e){
            e.printStackTrace();
        }
        KhachHang Domainkh = new KhachHang();
        Domainkh.setMa(qlkh.getMa());
        Domainkh.setTen(qlkh.getTen());
        Domainkh.setTenDem(qlkh.getTenDem());
        Domainkh.setHo(qlkh.getHo());
        Domainkh.setNgaySinh(Date.valueOf(qlkh.getNgaySinh()));
        Domainkh.setSdt(qlkh.getSdt());
        Domainkh.setThanhPho(qlkh.getThanhPho());
        Domainkh.setQuocGia(qlkh.getQuocGia());
        Domainkh.setDiaChi(qlkh.getDiaChi());
        Domainkh.setMatKhau(qlkh.getMatKhau());
        try {


//            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//            Validator validator = validatorFactory.getValidator();
//            Set<ConstraintViolation<KhachHang>> constraintViolations = validator.validate(Domainkh);
//            if (!constraintViolations.isEmpty()) {
//                String errMa = "";
//                String errTen = "";
//                String errTenDem = "";
//                String errHo = "";
//                String errNgaySinh = "";
//                String errSdt = "";
//                String errdiaChi = "";
//                String errthanhPho = "";
//                String errquocGia = "";
//                String errMatKhau = "";
//                for (ConstraintViolation<KhachHang> constraintViolation: constraintViolations) {
//                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
//                        errMa = constraintViolation.getMessage();
//                    } else if (constraintViolation.getPropertyPath().toString().equals("ten")) {
//                        errTen = constraintViolation.getMessage();
//                    } else if (constraintViolation.getPropertyPath().toString().equals("tenDem")) {
//                        errTenDem = constraintViolation.getMessage();
//                    } else if (constraintViolation.getPropertyPath().toString().equals("ho")) {
//                        errHo = constraintViolation.getMessage();
//                    } else if (constraintViolation.getPropertyPath().toString().equals("ngaySinh")) {
//                        errNgaySinh = constraintViolation.getMessage();
//                    } else if (constraintViolation.getPropertyPath().toString().equals("sdt")) {
//                        errSdt = constraintViolation.getMessage();
//                    } else if (constraintViolation.getPropertyPath().toString().equals("diaChi")) {
//                        errdiaChi  = constraintViolation.getMessage();
//                    }else if (constraintViolation.getPropertyPath().toString().equals("thanhPho")) {
//                        errthanhPho = constraintViolation.getMessage();
//                    }else if (constraintViolation.getPropertyPath().toString().equals("quocGia")) {
//                        errquocGia  = constraintViolation.getMessage();
//                    }else if (constraintViolation.getPropertyPath().toString().equals("matKhau")) {
//                        errMatKhau  = constraintViolation.getMessage();
//                    }
//                }
//                req.setAttribute("kh", Domainkh);
//                req.setAttribute("errMa", errMa);
//                req.setAttribute("errTen", errTen);
//                req.setAttribute("errTenDem", errTenDem);
//                req.setAttribute("errHo", errHo);
//                req.setAttribute("errNgaySinh", errNgaySinh);
//                req.setAttribute("errSdt", errSdt);
//                req.setAttribute("errdiaChi", errdiaChi);
//                req.setAttribute("errthanhPho", errthanhPho);
//                req.setAttribute("errquocGia", errquocGia);
//                req.setAttribute("errMatKhau", errMatKhau);
//                req.setAttribute("view","/views/khach_hang/create.jsp");
//                req.getRequestDispatcher("/views/layout.jsp")
//                        .forward(req,resp);
//            } else {
                khRepo.insert(Domainkh);
//                req.removeAttribute("kh");
//                req.removeAttribute("errMa");
//                req.removeAttribute("errTen");
//                req.removeAttribute("errTenDem");
//                req.removeAttribute("errHo");
//                req.removeAttribute("errNgaySinh");
//                req.removeAttribute("errSdt");
//                req.removeAttribute("errdiaChi");
//                req.removeAttribute("errthanhPho");
//                req.removeAttribute("errquocGia");
//                req.removeAttribute("errMatKhau");
                resp.sendRedirect("/Assignment_PH23038_war_exploded/khach-hang/index");
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }

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
