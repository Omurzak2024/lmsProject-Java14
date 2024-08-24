package peaksoft.lmsprojectjava14.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Task;
import peaksoft.lmsprojectjava14.repository.Lessonrepository;
import peaksoft.lmsprojectjava14.repository.TaskRepository;
import peaksoft.lmsprojectjava14.service.TaskService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final Lessonrepository lessonrepository;
    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                ()->new NoSuchElementException(
                        "Task with id" + id + "not found"
                )
        );
    }

    @Override
    public void updateTaskById(Long oldTask, Task newTask) {
        Task task = getTaskById(oldTask);
        task.setTaskName(newTask.getTaskName());
        task.setTaskText(newTask.getTaskText());
        task.setDeadLine(newTask.getDeadLine());
        taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Task with id" + id + "not found"
            );
        }
        taskRepository.deleteById(id);

    }
}
