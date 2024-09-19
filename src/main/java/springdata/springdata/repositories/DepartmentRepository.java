package springdata.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Doctor;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByCode(String code);
    Optional<Department> findByDirector(Doctor doctor);
}
