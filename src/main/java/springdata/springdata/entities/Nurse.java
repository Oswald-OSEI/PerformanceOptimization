package springdata.springdata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DiscriminatorValue("Nurse")
public class Nurse extends  Employee{
private String rotation;
private String salary;

@OneToOne
@JoinColumn(name = "Department")
private Department department;


public void setEmployeeType(){
    this.setEmployeeType("Nurse");
    }
}
