package peaksoft.lmsprojectjava14.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Course;
import peaksoft.lmsprojectjava14.repository.CompanyRepository;
import peaksoft.lmsprojectjava14.repository.CourseRepository;
import peaksoft.lmsprojectjava14.service.CourseService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);

    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException(
                        "Course with id" + id + " not found"
                )
        );
    }

    @Override
    public void updateCourseById(Long oldCourse, Course newCourse) {
        Course course = getCourseById(oldCourse);
        course.setCourseName(newCourse.getCourseName());
        course.setDateOfStart(newCourse.getDateOfStart());
        course.setDescription(newCourse.getDescription());
        courseRepository.save(course);

    }

    @Override
    public void deleteCourseById(Long id) {
        if (courseRepository.existsById(id)){
            courseRepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Course with id" + id + " not found"
            );
        }
        courseRepository.deleteById(id);

    }

    public Course createCourseInCompany(Long companyId, Course course) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        course.setCompany(company);
        return courseRepository.save(course);
    }
}
