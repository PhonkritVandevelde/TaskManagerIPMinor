package com.example.TaskManager.Service;

import com.example.TaskManager.ModelDTO.SubtaskDTO;
import com.example.TaskManager.ModelDTO.TaskModelDTO;
import com.example.TaskManager.Model.Subtask;
import com.example.TaskManager.Model.TaskModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskModelServiceImpl implements TaskModelService {
    private final TaskModelRepo taskModelRepo;

    public TaskModelServiceImpl(TaskModelRepo taskModelRepo) {
        this.taskModelRepo = taskModelRepo;
    }

    @Override
    public List<TaskModelDTO> getTaskModelList() {

        return taskModelRepo.findAll().stream().map(h -> {
            TaskModelDTO dto = new TaskModelDTO();

            dto.setDescription(h.getDescription());
            dto.setLocalDateTime(h.getLocalDateTime());
            dto.setNameTask(h.getNameTask());
            dto.setSubtasks(h.getSubtasks());
            dto.setId(h.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void addTaak(TaskModelDTO taskModelDTO) {

        TaskModel model = new TaskModel();

        model.setDescription(taskModelDTO.getDescription());
        model.setLocalDateTime(taskModelDTO.getLocalDateTime());
        model.setNameTask(taskModelDTO.getNameTask());
        model.setSubtasks(taskModelDTO.getSubtasks());
        model.setId(setVolgendeIDPrivate());

        taskModelRepo.save(model);
    }

    @Override
    public TaskModelDTO getTaskmetId(long id) {

        TaskModelDTO res = null;

        for (TaskModel model: taskModelRepo.findAll()){
            if (model.getId() == id){
                res = new TaskModelDTO();
                res.setSubtasks(model.getSubtasks());
                res.setNameTask(model.getNameTask());
                res.setLocalDateTime(model.getLocalDateTime());
                res.setDescription(model.getDescription());
                res.setId(model.getId());
            }
        }
        return res;
    }

    private long setVolgendeIDPrivate() {
        long res = 0;
        for (TaskModel tm: taskModelRepo.findAll()){
            if (tm != null && tm.getId() > res){
                res = tm.getId();
            }
        }
        return res+1;
    }

    @Override
    public void setVolgendeID(TaskModelDTO taskModelDTO) {
        long res = 0;
        long plusOne = 1;
        for (TaskModel tm: taskModelRepo.findAll()){
            if (res < tm.getId()){
                res = tm.getId();
            }
        } if (taskModelRepo.findAll().size() == 0 || taskModelRepo.findAll() == null){
            taskModelDTO.setId(plusOne);
        }
        taskModelDTO.setId(res+plusOne);

    }

    @Override
    public void editTask(TaskModelDTO taskModelDTO, long id) {
        TaskModel model = taskModelRepo.getOne(id);

        model.setDescription(taskModelDTO.getDescription());
        model.setLocalDateTime(taskModelDTO.getLocalDateTime());
        model.setNameTask(taskModelDTO.getNameTask());
        model.setSubtasks(taskModelDTO.getSubtasks());

        taskModelRepo.save(model);
    }

    @Override
    public void addSubtask(SubtaskDTO subtaskDTO, long id) {
       TaskModel taskModel = taskModelRepo.getOne(id);
       Subtask subtask = new Subtask();

       subtask.setDescription(subtaskDTO.getDescription());
       subtask.setNameTask(subtaskDTO.getNameTask());
       taskModel.addSubTask(subtask);
        this.taskModelRepo.save(taskModel);
    }

    @Override
    public void updateTask(TaskModelDTO taskModelDTO, long id) {
        TaskModel taskModel = new TaskModel();

        taskModel.setId(taskModelDTO.getId());
        taskModel.setLocalDateTime(taskModelDTO.getLocalDateTime());
        taskModel.setNameTask(taskModelDTO.getNameTask());
        taskModel.setDescription(taskModelDTO.getDescription());
        taskModel.setSubtasks(taskModelDTO.getSubtasks());

        this.taskModelRepo.save(taskModel);
    }
}
