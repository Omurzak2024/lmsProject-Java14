package peaksoft.lmsprojectjava14.service;

import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Instructor;

import java.util.List;

public interface InstructorService {

    void saveInstructor(Instructor instructor);
    List<Instructor> getAllInstructor();
    Instructor getInstructorById(Long id);
    void updateInstructorById(Long oldInstructor,Instructor newInstructor);
    void deleteInstructorById(Long id);
}
