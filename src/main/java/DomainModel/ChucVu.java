package DomainModel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table (name = "ChucVu")
public class ChucVu {
    @Id
    @Column (name = "Id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "Ma")
    private String ma;

    @Column (name = "Ten")
    private String ten;

    @OneToMany (mappedBy = "chucVu", fetch = FetchType.LAZY)
    List<NhanVien> listNhanVien;

}
