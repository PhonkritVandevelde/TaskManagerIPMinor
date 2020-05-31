package com.example.TaskManager;

import com.example.TaskManager.Model.Subtask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SubtaskTest {

    private Subtask subtask = new Subtask();


    @Test
    void testSetName(){
        subtask.setNameTask("test");
        assertEquals("test", subtask.getNameTask());
    }

    @Test
    void testSetDescription(){
        subtask.setDescription("test");
        assertEquals("test", subtask.getDescription());
    }
}
