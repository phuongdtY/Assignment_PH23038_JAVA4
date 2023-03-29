package DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "CuaHang")
public class CuaHang {

    @Id
    @Column (name = "Id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "Ma")
    private String ma;

    @Column (name = "Ten")
    private String ten;

    @Column (name = "DiaChi")
    private String diaChi;

    @Column (name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @OneToMany (mappedBy = "cuaHang", fetch = FetchType.LAZY)
    List<NhanVien> listNhanVien;
}
