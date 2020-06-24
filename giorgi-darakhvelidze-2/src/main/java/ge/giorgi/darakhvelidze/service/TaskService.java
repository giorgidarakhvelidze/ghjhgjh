package ge.giorgi.darakhvelidze.service;

import ge.giorgi.darakhvelidze.models.request.CreateTask;
import ge.giorgi.darakhvelidze.models.response.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(CreateTask req);

    List<TaskResponse> getTasks();

    void deleteTask(long taskId);
}
