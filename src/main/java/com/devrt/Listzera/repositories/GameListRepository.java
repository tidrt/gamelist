package com.devrt.Listzera.repositories;

import com.devrt.Listzera.entities.Game;
import com.devrt.Listzera.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
