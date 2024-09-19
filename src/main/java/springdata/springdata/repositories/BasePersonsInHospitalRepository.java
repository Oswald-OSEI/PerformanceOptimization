package springdata.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import springdata.springdata.entities.PersonsInHospital;

import java.util.List;


@NoRepositoryBean
public interface BasePersonsInHospitalRepository<T extends PersonsInHospital> extends JpaRepository<T, Long> {
    List<T> findAllBySurname(String surname);
}
