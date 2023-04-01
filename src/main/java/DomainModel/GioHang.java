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
@Table (name = "GioHang")
public class GioHang {
    @Id
    @Column (name = "Id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn (name = "IdKH", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn (name = "IdNV", nullable = false)
    private NhanVien nhanVien;

    @Column (name = "Ma")
    private String ma;

    @Column (name = "NgayTao")
    private Date ngayTao;

    @Column (name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column (name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column (name = "DiaChi")
    private String diaChi;

    @Column (name = "Sdt")
    private String sdt;

    @Column (name = "TrangThai")
    private int trangThai;

    @OneToMany (mappedBy = "gioHang", fetch = FetchType.LAZY)
    List<GioHangChiTiet> listGioHangChiTiet;
}
