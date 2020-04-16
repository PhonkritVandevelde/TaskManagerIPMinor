package com.example.TaskManager;

import com.example.TaskManager.Model.Subtask;
import com.example.TaskManager.ModelDTO.SubtaskDTO;
import com.example.TaskManager.ModelDTO.TaskModelDTO;
import com.example.TaskManager.Service.TaskModelService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TaskServiceTests {

    @Autowired
    private TaskModelService taskModelService;



    @Test
    void testGetTasks() {
        TaskModelDTO taskModelDTO = createTestTaskModelenToevoegenAanService();
        List<TaskModelDTO> taskModelDTOSlist = taskModelService.getTaskModelList();

        assertNotNull(taskModelDTOSlist);
        assertFalse(taskModelDTOSlist.isEmpty());
        assertEquals(1, taskModelDTOSlist.size());
        TaskModelDTO taskModelDTO1 = taskModelDTOSlist.get(0);
        assertNotNull(taskModelDTO1);
    }

    @Test
    void testUpdateTask() {
        TaskModelDTO taskModelDTO = createTestTaskModelenToevoegenAanService();
        assertEquals("testmodel", taskModelDTO.getDescription());


        taskModelDTO.setDescription("updatedtestmodel");
        taskModelService.updateTask(taskModelDTO, taskModelDTO.getId());
        assertEquals("updatedtestmodel", taskModelDTO.getDescription());
    }

    @Test
    void testGetSubtask() {
        TaskModelDTO taskModelDTO = createTestTaskModelenToevoegenAanService();

        Subtask subtask = new Subtask();
        subtask.setNameTask("testsubtaskmodel");
        subtask.setDescription("testsubtaskdescription");

        taskModelDTO.addSubTask(subtask);


        assertNotNull(taskModelDTO.getSubtasks());
        assertFalse(taskModelDTO.getSubtasks().isEmpty());
        assertEquals(1, taskModelDTO.getSubtasks().size());
        Subtask subtask1 = taskModelDTO.getSubtasks().get(0);
        assertNotNull(subtask1);
    }

    TaskModelDTO createTestTaskModelenToevoegenAanService(){
        TaskModelDTO taskModelDTO = new TaskModelDTO();
        taskModelService.setVolgendeID(taskModelDTO);
        taskModelDTO.setDescription("testmodel");
        taskModelDTO.setNameTask("testnaam");
        taskModelDTO.setLocalDateTime(LocalDateTime.now());
        taskModelService.addTaak(taskModelDTO);
        return taskModelDTO;
    }
}
