package DomainModel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
@Table (name = "MauSac")
public class MauSac {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

    @Pattern(regexp = "^[a-zA-Z0-9]{4,9}$", message = "Mã không không có ký tự đặc biệt và mã dài 4-9 ký tự")
    @Column (name = "Ma")
    private String ma;

    @NotEmpty(message = "không được để trống tên")
    @Column (name = "Ten")
    private String ten;

    @OneToMany (mappedBy = "mauSac", fetch = FetchType.LAZY)
    List<ChiTietSanPham> chiTietSanPhamList;;

}
