package springdata.springdata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DiscriminatorValue("Doctor")
public class Doctor extends  Employee {
    private String specialty;

    public void setEmployeeType(){
        this.setEmployeeType("Doctor");
    }

}
