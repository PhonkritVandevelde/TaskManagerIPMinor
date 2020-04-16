package com.example.TaskManager.Service;

import com.example.TaskManager.ModelDTO.SubtaskDTO;
import com.example.TaskManager.ModelDTO.TaskModelDTO;
import com.example.TaskManager.Model.Subtask;

import java.util.List;

public interface TaskModelService {
    List<TaskModelDTO> getTaskModelList();
    void addTaak(TaskModelDTO taskModelDTO);
    TaskModelDTO getTaskmetId(long id);
    void setVolgendeID(TaskModelDTO taskModelDTO);
    void editTask(TaskModelDTO taskModelDTO, long id);
    void addSubtask(SubtaskDTO subtaskDTO, long id);
    void updateTask(TaskModelDTO taskModelDTO, long id);
}
