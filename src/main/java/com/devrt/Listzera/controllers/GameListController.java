package com.devrt.Listzera.controllers;

import com.devrt.Listzera.dto.GameDTO;
import com.devrt.Listzera.dto.GameListDTO;
import com.devrt.Listzera.dto.GameMinDTO;
import com.devrt.Listzera.dto.ReplacementDTO;
import com.devrt.Listzera.entities.GameList;
import com.devrt.Listzera.services.GameListService;
import com.devrt.Listzera.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGames(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByGameList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
