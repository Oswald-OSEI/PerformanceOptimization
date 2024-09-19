package springdata.springdata.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Employee;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NurseDto {
    private long id;
    private String surname;
    private String address;
    private String tel_number;
    private String firstName;
    private String employeeId;
    private String rotation;
    private String salary;
    private Department department;

    public void setEmployeeType(){
        String employeeType = "Nurse";
        }

}
