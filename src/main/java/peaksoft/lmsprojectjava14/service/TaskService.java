package peaksoft.lmsprojectjava14.service;

import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Task;

import java.util.List;

public interface TaskService {

    void saveTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Long id);
    void updateTaskById(Long oldTask,Task newTask);
    void deleteTaskById(Long id);
}
