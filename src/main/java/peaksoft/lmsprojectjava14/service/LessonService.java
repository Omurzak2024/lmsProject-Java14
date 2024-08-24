package peaksoft.lmsprojectjava14.service;

import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Lesson lesson);
    List<Lesson> getAllLesson();
    Lesson getLessonById(Long id);
    void updateLessonById(Long oldLesson,Lesson newLesson);
    void deleteLessonById(Long id);
}
