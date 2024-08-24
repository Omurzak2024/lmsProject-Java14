package peaksoft.lmsprojectjava14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "task_gen")
    @SequenceGenerator(name = "task_gen",
    sequenceName = "task_seq",
    allocationSize = 1)
    private Long id;
    private String taskName;
    private String taskText;
    private int deadLine;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private Lesson lesson;

    public Task(String taskName, String taskText, int deadLine) {
        this.taskName = taskName;
        this.taskText = taskText;
        this.deadLine = deadLine;
    }


}
