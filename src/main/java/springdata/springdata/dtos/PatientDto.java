package springdata.springdata.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import springdata.springdata.entities.Bed;
import springdata.springdata.entities.Doctor;

public class PatientDto {
    private long id;
    private String Surname;
    private String address;
    private String tel_number;
    private String name;
    private String patientNumber;
    private String diagnosis;
    private Bed bed;
    private Doctor doctor;

}
