package ge.giorgi.darakhvelidze.service.impl;

import ge.giorgi.darakhvelidze.entities.Task;
import ge.giorgi.darakhvelidze.models.request.CreateTask;
import ge.giorgi.darakhvelidze.models.response.TaskResponse;
import ge.giorgi.darakhvelidze.repository.TaskRepository;
import ge.giorgi.darakhvelidze.service.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;

    @Override
    @Transactional
    public TaskResponse createTask(CreateTask req) {
        Task task = new Task();
        BeanUtils.copyProperties(req, task);
        task = taskRepository.save(task);

        TaskResponse taskResponse = new TaskResponse();
        BeanUtils.copyProperties(task, taskResponse);
        return taskResponse;
    }

    public List<TaskResponse> getTasks(){
        return taskRepository.findAll().stream().map(t -> {
            TaskResponse taskResponse = new TaskResponse();
            BeanUtils.copyProperties(t, taskResponse);
            return taskResponse;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteTask(long taskId) {
        taskRepository.delete(taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found")));
    }

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
