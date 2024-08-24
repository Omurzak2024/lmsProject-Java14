package peaksoft.lmsprojectjava14.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Instructor;
import peaksoft.lmsprojectjava14.repository.CompanyRepository;
import peaksoft.lmsprojectjava14.repository.InstructorRepository;
import peaksoft.lmsprojectjava14.service.InstructorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;;
    @Override
    public void saveInstructor(Instructor instructor) {
        instructorRepository.save(instructor);

    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException(
                        "Instructor with id" + id + "not found"
                )
        );
    }

    @Override
    public void updateInstructorById(Long oldInstructor, Instructor newInstructor) {
        Instructor instructor = getInstructorById(oldInstructor);
        instructor.setFirstName(newInstructor.getFirstName());
        instructor.setLastName(newInstructor.getLastName());
        instructor.setPhoneNumber(newInstructor.getPhoneNumber());
        instructor.setSpecialization(newInstructor.getSpecialization());
        instructorRepository.save(instructor);

    }

    @Override
    public void deleteInstructorById(Long id) {
        if (instructorRepository.existsById(id)){
            instructorRepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Instructor with id" + id + "not found"
            );
        }
        instructorRepository.deleteById(id);

        public Instructor assignInstructorToCompany(Long companyId, Long instructorId) {
            Company company = companyRepository.findById(companyId).orElseThrow();
            Instructor instructor = instructorRepository.findById(instructorId).orElseThrow();
            company.getInstructors().add(instructor);
            return instructorRepository.save(instructor);
        }
    }
}
