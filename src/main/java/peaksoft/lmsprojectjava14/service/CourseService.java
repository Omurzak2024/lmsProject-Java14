package peaksoft.lmsprojectjava14.service;

import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Course;

import java.util.List;

public interface CourseService {

    void saveCourse(Course course);
    List<Course> getAllCourse();
    Course getCourseById(Long id);
    void updateCourseById(Long oldCourse,Course newCourse);
    void deleteCourseById(Long id);
}
