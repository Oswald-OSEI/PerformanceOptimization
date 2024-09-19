package springdata.springdata.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import springdata.springdata.entities.Bed;
import springdata.springdata.entities.Department;
import springdata.springdata.entities.Ward;

import java.util.List;
import java.util.Optional;

public interface BedRepository extends JpaRepository<Bed, Long> {
    Optional<Bed> findByBedNumber(String bedNumber);

    List<Bed> findAllByWard(Ward ward);

    List<Bed> findAllByWardDepartment(Department department);

    @Query("SELECT COUNT(b) FROM Bed b WHERE b.ward.department = :department")
    long countTotalBedsInDepartment(@Param("department") Department department);

    @Query("SELECT b FROM Bed b WHERE b.ward.wardNumber = :wardNumber")
    List<Bed> findBedsByWardNumber(@Param("wardNumber") long wardNumber);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Bed (bed_number, ward) VALUES (:bedNumber, (SELECT id FROM Ward WHERE ward_number = :wardNumber))", nativeQuery = true)
    void addBed(@Param("bedNumber") String bedNumber, @Param("wardNumber") long wardNumber);

    // Update a bed
    @Modifying
    @Transactional
    @Query("UPDATE Bed b SET b.bedNumber = :newBedNumber, b.ward = (SELECT w FROM Ward w WHERE w.wardNumber = :newWardNumber) WHERE b.id = :bedId")
    void updateBed(@Param("bedId") Long bedId, @Param("newBedNumber") String newBedNumber, @Param("newWardNumber") long newWardNumber);
}