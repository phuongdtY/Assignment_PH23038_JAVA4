package DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "NhanVien")
public class NhanVien {

    @Id
    @Column (name = "Id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "Ma")
    private String ma;

    @Column (name = "Ten")
    private String ten;

    @Column (name = "TenDem")
    private String tenDem;

    @Column (name = "Ho")
    private String ho;

    @Column (name = "GioiTinh")
    private String gioiTinh;

    @Column (name = "NgaySinh")
    @Type( type = "date")
    private Date ngaySinh;

    @Column (name = "DiaChi")
    private String diaChi;

    @Column (name = "Sdt")
    private String sdt;

    @Column (name = "MatKhau")
    private String matKhau;

    @ManyToOne
    @JoinColumn (name = "IdCH", nullable = false)
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn (name = "IdCV", nullable = false)
    private ChucVu chucVu;

    @Column (name = "IdGuiBC")
    private String idGuiBaoCao;

    @Column (name = "TrangThai")
    private int trangThai;

    @OneToMany (mappedBy = "nhanVien", fetch = FetchType.LAZY)
    List<GioHang> listGioHang;

    @OneToMany (mappedBy = "nhanVienHoaDon", fetch = FetchType.LAZY)
    List<HoaDon> listHoaDon;

}
