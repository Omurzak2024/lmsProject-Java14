package peaksoft.lmsprojectjava14.service;

import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(Long id);
    void updateStudentById(Long oldStudent,Student newStudent);
    void deleteStudentById(Long id);
}
