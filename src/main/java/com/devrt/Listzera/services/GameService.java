package com.devrt.Listzera.services;

import com.devrt.Listzera.dto.GameDTO;
import com.devrt.Listzera.dto.GameMinDTO;
import com.devrt.Listzera.entities.Game;
import com.devrt.Listzera.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {  // this findById returns an optional type, to get that id we need to use .get();
        Game result = gameRepository.findById(id).get(); // implementar tratamento de excecao caso nao exista o id
        return new GameDTO(result);
    }

    @Transactional(readOnly = true) // to maintain ACID
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
