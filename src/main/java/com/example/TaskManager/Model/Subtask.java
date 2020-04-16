package com.example.TaskManager.Model;

import com.example.TaskManager.Exception.ModelException;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subtask {
    @Id
    private String nameTask;
    private String description;

    public Subtask(String nameTask, String description) {
        this.nameTask = nameTask;
        this.description = description;
    }

    public Subtask() {
    }

    public String getNameTask() {
        return nameTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) throw new ModelException("Description is leeg");
        this.description = description;
    }

    public void setNameTask(String nameTask) {
        if (nameTask == null || nameTask.isBlank()) throw new ModelException("nameTask is leeg");
        this.nameTask = nameTask;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "nameTask='" + nameTask + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
