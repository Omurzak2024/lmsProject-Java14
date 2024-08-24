package peaksoft.lmsprojectjava14.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Group;
import peaksoft.lmsprojectjava14.entity.Student;
import peaksoft.lmsprojectjava14.repository.GroupRepository;
import peaksoft.lmsprojectjava14.repository.StudentRepository;
import peaksoft.lmsprojectjava14.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException(
                        "Student with id" + id + "not found"
                )
        );
    }

    @Override
    public void updateStudentById(Long oldStudent, Student newStudent) {
        Student student = getStudentById(oldStudent);
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setPhoneNumber(newStudent.getPhoneNumber());
        student.setEmail(newStudent.getEmail());
        student.setStudyFormat(newStudent.getStudyFormat());
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Student with id" + id + "not found"
            );
        }
        studentRepository.deleteById(id);
    }

    //method

    public Student addStudentToGroup(Long groupId, Long studentId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();
        group.getStudents().add(student);
        student.setGroup(group);
        return studentRepository.save(student);
    }
}
