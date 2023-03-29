package DomainModel;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "ChiTietSP")
public class ChiTietSanPham{
    @Id
    @Column (name = "Id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn (name = "IdSP", nullable = false)
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn (name = "IdNsx", nullable = false)
    private NhaSanXuat nsx;

    @ManyToOne
    @JoinColumn (name = "IdMauSac", nullable = false)
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn (name = "IdDongSP", nullable = false)
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

}
