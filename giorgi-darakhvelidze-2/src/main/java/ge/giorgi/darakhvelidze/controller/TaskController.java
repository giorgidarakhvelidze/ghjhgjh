package ge.giorgi.darakhvelidze.controller;

import ge.giorgi.darakhvelidze.models.request.CreateTask;
import ge.giorgi.darakhvelidze.models.response.TaskResponse;
import ge.giorgi.darakhvelidze.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "task")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Api(description = "This service is to control tasks")
public class TaskController {

    TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @ApiOperation("Creates task from provided body")
    public TaskResponse createTask(@ApiParam("Create task body") @RequestBody CreateTask request){
        return taskService.createTask(request);
    }

    @GetMapping
    @ResponseBody
    @ApiOperation("Get all tasks which is already created")
    public List<TaskResponse> getTasks(){
        return taskService.getTasks();
    }

    @DeleteMapping(path = "{taskId}")
    @ApiOperation("Delete existed tasks")
    public void deleteTask(@ApiParam("Unique identifier in database, error will be thrown if not found") @PathVariable("taskId") long taskId){
        taskService.deleteTask(taskId);
    }



    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
