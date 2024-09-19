package springdata.springdata.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springdata.springdata.entities.Bed;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Nurse;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WardDto {

    private long id;


    private Department department;

    private Nurse supervisor;

    private long wardNumber;


    private List<Bed> bedList;
}
