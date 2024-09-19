package springdata.springdata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String building;

    @OneToOne
    @JoinColumn(name = "director")
    private Doctor director;

    @OneToMany(mappedBy = "department")
    private List<Ward> wardList;
}
