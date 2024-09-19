package springdata.springdata.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private long id;
    private String surname;
    private String address;
    private String tel_number;
    private String firstName;
    private String employeeId;
    private String employeeType;
    private String specialty;

    public void setEmployeeType() {
        String employeeType= "Doctor";
    }
}
