package peaksoft.lmsprojectjava14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "course_gen")
    @SequenceGenerator(name = "course_gen",
    sequenceName = "course_seq",
    allocationSize = 1)
    private Long id;
    private String courseName;
    private LocalDate dateOfStart;
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private Company company;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private Instructor instructor;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private Lesson lesson;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Group> groups;

    public Course(String courseName, LocalDate dateOfStart, String description) {
        this.courseName = courseName;
        this.dateOfStart = dateOfStart;
        this.description = description;
    }

}
