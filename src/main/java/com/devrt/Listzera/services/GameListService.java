package com.devrt.Listzera.services;

import com.devrt.Listzera.dto.GameDTO;
import com.devrt.Listzera.dto.GameListDTO;
import com.devrt.Listzera.dto.GameMinDTO;
import com.devrt.Listzera.entities.Game;
import com.devrt.Listzera.entities.GameList;
import com.devrt.Listzera.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // to maintain ACID
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
