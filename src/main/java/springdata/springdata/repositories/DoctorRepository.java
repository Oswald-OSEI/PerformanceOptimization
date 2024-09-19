package springdata.springdata.repositories;

import springdata.springdata.entities.Doctor;
import springdata.springdata.entities.Patient;

import java.util.List;

public interface DoctorRepository extends EmployeeRepository<Doctor> {
    List<Doctor> findAllBySpecialty(String Specialty);
    List<Doctor> findAllBySurname(String surname);
    List<Doctor> findBySpecialtyAndSurname(String Specialty, String surname);
}
