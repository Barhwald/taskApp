package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        List<TrelloBoardDto> filteredBoards = trelloBoards.
                stream().
                filter(board -> board.getId() != null && board.getName() != null && board.getName().contains("Kodilla"))
                .toList();

        filteredBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
        });
    }
}