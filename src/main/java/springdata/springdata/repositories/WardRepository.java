package springdata.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Nurse;
import springdata.springdata.entities.Ward;

import java.util.List;
import java.util.Optional;

public interface  WardRepository extends JpaRepository<Ward,  Long> {
    List<Ward> findAllByDepartment(Department department);
    List<Ward> findAllByDepartmentCode(String departmentCode);
    Optional<Ward> findBySupervisor(Nurse nurse);
}
