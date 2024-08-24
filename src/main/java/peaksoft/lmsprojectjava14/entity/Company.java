package peaksoft.lmsprojectjava14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "company_gen")
    @SequenceGenerator(name = "company_gen",
    sequenceName = "company_seq",
    allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST })
    private List<Course> courses;

    @ManyToMany(mappedBy = "companies",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Instructor> instructors;


    public Company(String name, String country, String address, String phoneNumber) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
