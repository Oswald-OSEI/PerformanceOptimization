package springdata.springdata.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import springdata.springdata.entities.Doctor;
import springdata.springdata.entities.Ward;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private long id;

    private String code;

    private String building;

    private Doctor director;

    private List<Ward> wardList;
}
