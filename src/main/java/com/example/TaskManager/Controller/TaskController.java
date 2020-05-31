package com.example.TaskManager.Controller;

import com.example.TaskManager.ModelDTO.SubtaskDTO;
import com.example.TaskManager.ModelDTO.TaskModelDTO;
import com.example.TaskManager.Model.Subtask;
import com.example.TaskManager.Service.TaskModelService;
import com.example.TaskManager.Service.TaskModelServiceImpl;
import com.example.TaskManager.Service.TaskModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    //TODO: ERRORS OPVANGEN IN FORMS

    @Autowired
    private TaskModelService taskService;

    @Autowired
    public TaskController(TaskModelRepo taskModelRepo) {
        this.taskService = new TaskModelServiceImpl(taskModelRepo);
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        List<TaskModelDTO> taskModelList = taskService.getTaskModelList();
        model.addAttribute("taskModelList", taskModelList);
        return "task";
    }

    @GetMapping("tasks/{id}")
    public String getTaskDetail(@PathVariable(name = "id") long id, Model model){

        model.addAttribute("id",id);
        TaskModelDTO dto = taskService.getTaskmetId(id);
        if (dto != null){
            model.addAttribute("detailtask", dto);
            model.addAttribute("subtasks", dto.getSubtasks());
        } else {
            model.addAttribute("detailtask", null);
        }

        return "taskdetail";
    }

    @GetMapping("tasks/new")
    public String newTask(Model model){
        model.addAttribute("taskModelDTO", new TaskModelDTO());
        return "taskform";
    }

    @PostMapping("tasks/new")
    public String postNewTask(@Valid @ModelAttribute TaskModelDTO taskModelDTO){
        taskService.setVolgendeID(taskModelDTO);
        taskService.addTaak(taskModelDTO);
        return "redirect:/tasks";
    }

    @GetMapping("tasks/edit/{id}")
    public String getEditForm(@PathVariable (name = "id") long id,Model model){
        model.addAttribute("id",id);
        TaskModelDTO taskManagerTaskModel = taskService.getTaskmetId(id);
        model.addAttribute("task", taskManagerTaskModel);
        return "editform";
    }



    @PostMapping("tasks/edit/{id}")
    public String editTask(@PathVariable(name = "id") long id, @ModelAttribute @Valid TaskModelDTO taskDTO, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("id",id);
            model.addAttribute("getSelectedTask",taskService.getTaskmetId(id));
            return "editTask";
        }
        this.taskService.editTask(taskDTO, id);
        return "redirect:/tasks/{id}";
    }

    @GetMapping("tasks/{id}/sub/create")
    public String getSubTaskForm(@PathVariable (name = "id") long id, Model model){
        model.addAttribute("subtask", new SubtaskDTO());
        model.addAttribute("id",id);
        TaskModelDTO taskModel = taskService.getTaskmetId(id);
        model.addAttribute("task", taskModel);

        return "subtaskform";
    }

    @PostMapping("tasks/{id}")
    public String voegSubTaskToe(@PathVariable (name = "id") long id,
                                 @Valid @ModelAttribute Subtask subtask){
        TaskModelDTO dto = taskService.getTaskmetId(id);
        SubtaskDTO subtaskDTO = new SubtaskDTO();

        subtaskDTO.setDescription(subtask.getDescription());
        subtaskDTO.setNameTask(subtask.getNameTask());
        taskService.addSubtask(subtaskDTO,id);
        System.out.println("subtask aangemaakt" + subtask.toString());
        System.out.println(dto.getSubtasks().toString() + "lijn 97");
        return "redirect:/tasks/" + id;

    }
}
