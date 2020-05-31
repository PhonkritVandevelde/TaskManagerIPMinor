package com.example.TaskManager;

import com.example.TaskManager.ModelDTO.SubtaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SubtaskDTOTests {

    private SubtaskDTO subtaskDTO = new SubtaskDTO();


    @Test
    void testSetName(){
        subtaskDTO.setNameTask("test");
        assertEquals("test", subtaskDTO.getNameTask());
    }

    @Test
    void testSetDescription(){
        subtaskDTO.setDescription("test");
        assertEquals("test", subtaskDTO.getDescription());
    }

    @Test
    void testToString(){
        subtaskDTO.setDescription("test");
        subtaskDTO.setNameTask("test");

        assertEquals("Subtask{nameTask='test', description='test'}", subtaskDTO.toString());
    }
}
