package DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "HoaDon")
public class HoaDon {
    @Id
    @Column (name = "Id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn (name = "IdKH")
    private KhachHang khachHangHoaDon;

    @ManyToOne
    @JoinColumn (name = "IdNv")
    private NhanVien nhanVienHoaDon;

    @Column (name = "Ma")
    private String ma;

    @Column  (name = "NgayTao")
    private Date ngayTao;

    @Column (name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column (name = "NgayShip")
    private Date ngayShip;

    @Column (name = "NgayNhan")
    private Date ngayNhan;

    @Column (name = "TinhTrang")
    private int tinhTrang;

    @Column (name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column (name = "DiaChi")
    private String diaChi;

    @Column (name = "Sdt")
    private String sdt;

    @OneToMany (mappedBy = "hoaDon", fetch = FetchType.LAZY)
    List<HoaDonChiTiet> listHoaDonChiTiet;

}
