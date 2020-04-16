package com.example.TaskManager.ModelDTO;

import com.example.TaskManager.Exception.ModelException;
import com.example.TaskManager.Model.Subtask;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskModelDTO {
    private long id;
    private String nameTask, description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime localDateTime;
    private List<Subtask> subtasks;

    public TaskModelDTO(String nameTask, LocalDateTime localDateTime , String description) {
        this.nameTask = nameTask;
        this.description = description;
        this.localDateTime = localDateTime;
        subtasks = new ArrayList<>();
    }

    public TaskModelDTO() {
        subtasks = new ArrayList<>();
    }

    public String getNameTask() {
        return nameTask;
    }
    public long getId(){
        return id;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null){
            throw new ModelException("Local date time invalid");
        }
        this.localDateTime = localDateTime;
    }
    public void setDescription(String description) {
        if (description == null || description.isBlank()) throw new ModelException("Description is leeg");
        this.description = description;
    }
    public void setNameTask(String nameTask) {
        if (nameTask == null || nameTask.isBlank()) throw new ModelException("nameTask is leeg");
        this.nameTask = nameTask;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getNameTask() + ": due " + getLocalDateTime();
    }
    public void addSubTask(Subtask subtask){
        if (subtask != null){
            this.subtasks.add(subtask);
        }
    }
    public List<Subtask> getSubtasks() {
        return subtasks;
    }
    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

}
