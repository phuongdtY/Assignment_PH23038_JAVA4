package view_model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class QLChucVu {
    @NotNull (message = "không được để trống mã")
    private String ma;
    @NotNull (message = "không được để trống tên")
    private String ten;
}
