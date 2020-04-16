package com.example.TaskManager.Model;

import com.example.TaskManager.Exception.ModelException;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
public class TaskModel {
    @Id
    private long id;
    @NotEmpty
    private String nameTask, description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime localDateTime;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Subtask> subtasks;


    public TaskModel(String nameTask, LocalDateTime localDateTime , String description) {
        this.nameTask = nameTask;
        this.id = id;
        this.description = description;
        this.localDateTime = localDateTime;
        subtasks = new ArrayList<>();


    }

    public TaskModel() {
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
            subtasks.add(subtask);
        }
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

}
