package peaksoft.lmsprojectjava14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.lmsprojectjava14.enums.StudyFormat;
@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student_gen")
    @SequenceGenerator(name = "student_gen",
    sequenceName = "student_seq",
    allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private StudyFormat studyFormat;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private Group group;

    public Student(String firstName, String lastName, String phoneNumber, String email, StudyFormat studyFormat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
    }


}
