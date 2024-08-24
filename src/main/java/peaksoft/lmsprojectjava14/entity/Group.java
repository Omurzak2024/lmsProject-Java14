package peaksoft.lmsprojectjava14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "group_gen")
    @SequenceGenerator(name = "group_gen",
    sequenceName = "group_seq",
    allocationSize = 1)
    private Long id;
    private String groupName;
    @Column(name = "image_link")
    private String imageLink;
    private String description;


    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Course> courses;

    @OneToMany(mappedBy = "student",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Student> students;

    public Group(String groupName, String imageLink, String description) {
        this.groupName = groupName;
        this.imageLink = imageLink;
        this.description = description;
    }


}
