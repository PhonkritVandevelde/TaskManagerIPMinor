package com.example.TaskManager;

import com.example.TaskManager.Model.Subtask;
import com.example.TaskManager.ModelDTO.TaskModelDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskDTOTests {


    private TaskModelDTO taskModelDTO = new TaskModelDTO();

    @Test
    void testSetName(){
        taskModelDTO.setNameTask("test");
        assertEquals("test", taskModelDTO.getNameTask());
    }

    @Test
    void testSetDescription(){
        taskModelDTO.setDescription("test");
        assertEquals("test", taskModelDTO.getDescription());
    }

    @Test
    void testSetID(){
        taskModelDTO.setId(1);
        assertEquals(1, taskModelDTO.getId());
    }

    @Test
    void testGetSubtask(){
        Subtask subtask = new Subtask();
        taskModelDTO.addSubTask(subtask);
        assertEquals(1, taskModelDTO.getSubtasks().size());
    }

    @Test
    void testNewTaks(){
        LocalDateTime localDateTime = LocalDateTime.of(2020,10,10,10,10);

        TaskModelDTO taskModelDTO = new TaskModelDTO("test", localDateTime, "test" );
        assertNotNull(taskModelDTO);

        }


}
