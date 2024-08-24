package peaksoft.lmsprojectjava14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "intructors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_gen",
    sequenceName = "instructor_seq",
    allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String specialization;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Company> companies;

    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
   private List<Course> courses;

    public Instructor(String firstName, String lastName, String specialization, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
    }


}
