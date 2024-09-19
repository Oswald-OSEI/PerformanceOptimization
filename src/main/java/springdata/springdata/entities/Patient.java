package springdata.springdata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("Patient")
public class Patient extends PersonsInHospital {
    private String name;
    private String patientNumber;
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "bed")
    private Bed bed;

    @OneToOne
    @JoinColumn(name = "Doctor")
    private Doctor doctor;

}
