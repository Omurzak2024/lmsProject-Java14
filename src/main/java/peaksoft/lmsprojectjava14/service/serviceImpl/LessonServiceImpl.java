package peaksoft.lmsprojectjava14.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Course;
import peaksoft.lmsprojectjava14.entity.Lesson;
import peaksoft.lmsprojectjava14.repository.CourseRepository;
import peaksoft.lmsprojectjava14.repository.Lessonrepository;
import peaksoft.lmsprojectjava14.service.LessonService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final Lessonrepository lessonrepository;
    private final CourseRepository courseRepository;
    @Override
    public void saveLesson(Lesson lesson) {
        lessonrepository.save(lesson);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return lessonrepository.findAll();
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonrepository.findById(id).orElseThrow(
                ()->new NoSuchElementException(
                        "Lesson with id" + id +"not found"
                )
        );
    }

    @Override
    public void updateLessonById(Long oldLesson, Lesson newLesson) {
        Lesson lesson =getLessonById(oldLesson);
        lesson.setLessonName(newLesson.getLessonName());
        lessonrepository.save(lesson);

    }

    @Override
    public void deleteLessonById(Long id) {
        if (lessonrepository.existsById(id)){
            lessonrepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Lesson with id" + id + "not found"
            );
        }
        lessonrepository.deleteById(id);
    }

    // Specific Method
    public Lesson createLessonForCourse(Long courseId, Lesson lesson) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }
}
