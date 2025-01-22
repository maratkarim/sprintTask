package kz.bitlab.practiceTask.service;

import kz.bitlab.practiceTask.model.Task;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class TaskDB {

    private List<Task> taskList = new ArrayList<>();

    public TaskDB(){
        taskList.add(new Task(1l, "Complete Task 7 from Spring Boot till the end of lesson", "23.10.2020", true));
        taskList.add(new Task(2l, "Clear home and buy food", "25.10.2020", true));
        taskList.add(new Task(3l, "Complete all home tasks at the weekend", "28.10.2020", false));
        taskList.add(new Task(4l, "Develop simple project in Spring Boot for the final", "12.12.2020", false));
        taskList.add(new Task(5l, "Learn Italian language", "01.05.2021", true));
    }

    public Task getTask(Long id){
        return taskList.stream()
                .filter(task -> task.getId()
                                .equals(id))
                .findFirst()
                .orElseThrow();
    }

    public void updateTask(Long id, String name, String deadline, boolean isComplete){
        for(Task task : taskList){
            if (id == task.getId()){
                task.setName(name);
                task.setDeadlineDate(deadline);
                task.setCompleted(isComplete);
            }
        }
    }

}
