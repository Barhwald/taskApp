package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "A title", "Some content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, task.getId());
        assertEquals("A title", task.getTitle());
        assertEquals("Some content", task.getContent());
    }

    @Test
    void shouldMapToTaskDto() {
        //Given
        Task task = new Task("Title", "Content");
        Long id = task.getId();

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(id, taskDto.getId());
        assertEquals("Title", taskDto.getTitle());
        assertEquals("Content", taskDto.getContent());
    }

    @Test
    void shouldMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Title", "Content"));
        taskList.add(new Task("Title1", "Content1"));

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(2, taskDtoList.size());
    }

}