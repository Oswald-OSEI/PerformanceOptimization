package springdata.springdata.repositories;

import springdata.springdata.entities.Department;
import springdata.springdata.entities.Nurse;
import springdata.springdata.entities.Ward;

import java.util.List;

public interface NurseRepository extends EmployeeRepository<Nurse> {
    List<Nurse> findAllBySurname(String surname);
    List<Nurse> findAllByRotation(String rotation);
    List<Nurse> findAllByFirstName(String firstName);
    List<Nurse> findAllByDepartment(Department department);

}
