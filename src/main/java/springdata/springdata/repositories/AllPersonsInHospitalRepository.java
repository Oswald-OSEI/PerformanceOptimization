package springdata.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.springdata.entities.PersonsInHospital;

import java.util.List;

@Repository
public interface AllPersonsInHospitalRepository extends JpaRepository<PersonsInHospital,Long> {
    List<PersonsInHospital> findAllBySurname(String surname);
    List<PersonsInHospital> findAllByAddress(String address);
}
