package peaksoft.lmsprojectjava14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Company;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
