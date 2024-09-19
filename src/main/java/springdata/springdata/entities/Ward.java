package springdata.springdata.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @OneToOne
    @JoinColumn(name = "supervisor")
    private Nurse supervisor;

    private long wardNumber;

    @OneToMany(mappedBy = "ward")
    @JsonManagedReference
    private List<Bed> bedList;
}
