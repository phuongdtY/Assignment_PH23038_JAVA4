package DomainModel;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "ChiTietSP")
public class ChiTietSanPham{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

    @ManyToOne
    @JoinColumn (name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn (name = "IdNsx")
    private NhaSanXuat nsx;

    @ManyToOne
    @JoinColumn (name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn (name = "IdDongSP")
    private DongSanPham dongSanPham;

    @Column (name = "NamBH")
    private int namBaoHanh;

    @Column (name = "MoTa")
    private String moTa;

    @Column (name = "SoLuongTon")
    private int soLuongTon;

    @Column (name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column (name = "GiaBan")
    private BigDecimal giaBan;

    @OneToMany (mappedBy = "chiTietSp",fetch = FetchType.LAZY)
    List<GioHangChiTiet> listGioHangChiTiet;

    @OneToMany (mappedBy = "chiTietSpHoaDon",fetch = FetchType.LAZY)
    List<HoaDonChiTiet> listHoaDonChiTiet;

}
