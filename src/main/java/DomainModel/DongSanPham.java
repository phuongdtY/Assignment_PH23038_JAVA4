package DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "DongSP")
public class DongSanPham {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

    @Column (name = "Ma")
    private String ma;

    @Column (name = "Ten")
    private String ten;

    @OneToMany (mappedBy = "dongSanPham", fetch = FetchType.LAZY)
    List<ChiTietSanPham> chiTietSanPhamList;

}
