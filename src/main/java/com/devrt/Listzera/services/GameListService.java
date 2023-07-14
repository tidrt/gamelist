package com.devrt.Listzera.services;

import com.devrt.Listzera.dto.GameDTO;
import com.devrt.Listzera.dto.GameListDTO;
import com.devrt.Listzera.dto.GameMinDTO;
import com.devrt.Listzera.entities.Game;
import com.devrt.Listzera.entities.GameList;
import com.devrt.Listzera.repositories.GameListRepository;
import com.devrt.Listzera.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true) // to maintain ACID
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
