package DomainModel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "KhachHang")
public class KhachHang{
    @Id
    @Column(name = "Id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = "^[a-zA-Z0-9]{4,9}$", message = "Mã không không có ký tự đặc biệt và mã dài 4-9 ký tự")
    @Column(name = "Ma")
    private String ma;

    @NotEmpty(message = "không được để trống tên")
    @Column(name = "Ten")
    private String ten;

    @NotEmpty(message = "không được để trống tên Đệm")
    @Column(name = "TenDem")
    private String tenDem;

    @NotEmpty(message = "không được để trống Họ")
    @Column(name = "Ho")
    private String ho;

//    @NotEmpty(message = "không được để trống ngày Sinh")
    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @NotEmpty(message = "không được để trống số điện thoại")
    @Column(name = "Sdt")
    private String sdt;

    @NotEmpty(message = "không được để trống địa chỉ")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotEmpty(message = "không được để trống thanh phố")
    @Column(name = "ThanhPho")
    private String thanhPho;

    @NotEmpty(message = "không được để trống quốc gia")
    @Column(name = "QuocGia")
    private String quocGia;

    @NotEmpty(message = "không được để trống mật khẩu")
    @Column(name = "MatKhau")
    private String matKhau;

    @OneToMany (mappedBy = "khachHang", fetch = FetchType.LAZY)
    List<GioHang> listGioHang;

    @OneToMany (mappedBy = "khachHangHoaDon", fetch = FetchType.LAZY)
    List<HoaDon> listHoaDon;

}
