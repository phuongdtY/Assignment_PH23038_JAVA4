package DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn (name = "IdHoaDon")
    private HoaDon hoaDon;

    @Id
    @ManyToOne
    @JoinColumn (name = "IdChiTietSP")
    private ChiTietSanPham chiTietSpHoaDon;

    @Column (name = "SoLuong")
    private int soLuong;

    @Column (name = "DonGia")
    private BigDecimal donGia;
}
