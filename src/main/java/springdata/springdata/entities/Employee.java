package springdata.springdata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Employee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends PersonsInHospital {
    private String firstName;
    private String employeeId;
    private String employeeType;
}
