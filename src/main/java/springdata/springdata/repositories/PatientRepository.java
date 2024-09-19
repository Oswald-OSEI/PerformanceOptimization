package springdata.springdata.repositories;

import org.springframework.stereotype.Repository;
import springdata.springdata.entities.Bed;
import springdata.springdata.entities.Patient;
import springdata.springdata.entities.Ward;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends BasePersonsInHospitalRepository<Patient>{
    List<Patient> findAllByDiagnosis(String diagnosis);
    List<Patient> findAllBySurname(String surname);
    List<Patient> findAllByName(String firstName);
    List<Patient> findAllByBed(Bed bed);
    Optional<Patient> findByBed(Bed bed);
    List<Patient> findAllByBedWard(Ward ward);
}
