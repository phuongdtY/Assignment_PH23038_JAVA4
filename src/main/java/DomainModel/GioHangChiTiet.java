package DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "GioHangChiTiet")
public class GioHangChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn (name = "IdGioHang", nullable = false)
    private GioHang gioHang;

    @Id
    @ManyToOne
    @JoinColumn (name = "IdChiTietSP", nullable = false)
    private ChiTietSanPham chiTietSp;

    @Column (name = "SoLuong")
    private int soLuong;

    @Column (name = "DonGia")
    private BigDecimal donGia;

    @Column (name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;
}
