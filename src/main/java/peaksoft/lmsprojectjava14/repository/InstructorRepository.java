package peaksoft.lmsprojectjava14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Instructor;

@Repository
@Transactional
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
