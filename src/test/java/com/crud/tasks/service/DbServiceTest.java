package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DbServiceTest {

    @Autowired
    private DbService dbService;

    @Test
    void findTaskById() throws TaskNotFoundException {
        //Given
        Task task = new Task("A title", "sgbdgsdvdfzgdbxf");
        dbService.saveTask(task);

        //When
        Long id = task.getId();
        Task savedTask = dbService.getTask(id);

        //Then
        assertEquals(id, savedTask.getId());
    }

}