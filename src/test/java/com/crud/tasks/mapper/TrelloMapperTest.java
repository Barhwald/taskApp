package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void shouldMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(new TrelloBoardDto("1", "Kodilla projects", new ArrayList<>()));
        trelloBoardDtoList.add(new TrelloBoardDto("2", "Canvas", new ArrayList<>()));

        //When
        List<TrelloBoard> trelloBoardlist =  trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(2, trelloBoardlist.size());
        assertEquals("Kodilla projects", trelloBoardlist.get(0).getName());
        assertEquals("Canvas", trelloBoardlist.get(1).getName());
    }

    @Test
    void shouldMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(new TrelloBoard("1", "Kodilla projects", new ArrayList<>()));
        trelloBoardList.add(new TrelloBoard("2", "Happy days", new ArrayList<>()));

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(2, trelloBoardDtoList.size());
        assertEquals("Kodilla projects", trelloBoardDtoList.get(0).getName());
        assertEquals("Happy days", trelloBoardDtoList.get(1).getName());
    }

    @Test
    void shouldMapToList() {
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(new TrelloListDto("1", "To do", false));
        trelloListDtoList.add(new TrelloListDto("2", "WIP", false));
        trelloListDtoList.add(new TrelloListDto("3", "In review", false));

        //When
        List<TrelloList> trelloListList = trelloMapper.mapToList(trelloListDtoList);

        //Then
        assertEquals(3, trelloListList.size());
        assertEquals("To do", trelloListList.get(0).getName());
        assertEquals("WIP", trelloListList.get(1).getName());
        assertEquals("In review", trelloListList.get(2).getName());
    }

    @Test
    void shouldMapToListDto() {
        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(new TrelloList("1", "To do", false));
        trelloListList.add(new TrelloList("2", "WIP", false));
        trelloListList.add(new TrelloList("3", "In review", false));

        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloListList);

        //Then
        assertEquals(3, trelloListDtoList.size());
        assertEquals("To do", trelloListDtoList.get(0).getName());
        assertEquals("WIP", trelloListDtoList.get(1).getName());
        assertEquals("In review", trelloListDtoList.get(2).getName());
    }

    @Test
    void shouldMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Controller",
                "Trello controller needs to be upgraded",
                "top",
                "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("Controller", trelloCard.getName());
        assertEquals("Trello controller needs to be upgraded", trelloCard.getDescription());
        assertEquals("top", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }

    @Test
    void shouldMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Controller",
                "Trello controller needs to be upgraded",
                "top",
                "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("Controller", trelloCardDto.getName());
        assertEquals("Trello controller needs to be upgraded", trelloCardDto.getDescription());
        assertEquals("top", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }

}