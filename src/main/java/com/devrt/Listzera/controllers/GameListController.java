package com.devrt.Listzera.controllers;

import com.devrt.Listzera.dto.GameDTO;
import com.devrt.Listzera.dto.GameListDTO;
import com.devrt.Listzera.dto.GameMinDTO;
import com.devrt.Listzera.entities.GameList;
import com.devrt.Listzera.services.GameListService;
import com.devrt.Listzera.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
