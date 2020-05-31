package com.example.TaskManager;

import com.example.TaskManager.Model.Subtask;
import com.example.TaskManager.Model.TaskModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskTests {
    private TaskModel taskModel = new TaskModel();

    @Test
    void testSetName(){
        taskModel.setNameTask("test");
        assertEquals("test", taskModel.getNameTask());
    }

    @Test
    void testSetDescription(){
        taskModel.setDescription("test");
        assertEquals("test", taskModel.getDescription());
    }

    @Test
    void testSetID(){
        taskModel.setId(1);
        assertEquals(1, taskModel.getId());
    }

    @Test
    void testGetSubtask(){
        Subtask subtask = new Subtask();
        taskModel.addSubTask(subtask);
        assertEquals(1, taskModel.getSubtasks().size());
    }

    @Test
    void testToString(){
       taskModel.setDescription("test");
       taskModel.setNameTask("test");
       taskModel.setLocalDateTime(LocalDateTime.of(2020,10,10,10,10));
       taskModel.setId(1);

        assertEquals("test: due 2020-10-10T10:10", taskModel.toString());

        assertNotNull(taskModel);
    }
}
