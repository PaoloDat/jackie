package ru.vazisu.jackie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vazisu.jackie.model.GameAtDraw;

import java.util.List;

public interface GameAtDrawRepository extends JpaRepository<GameAtDraw, Integer> {

    GameAtDraw findTopByOrderByIdDesc();

    List<GameAtDraw> findByDrawNumberGreaterThanAndIdGreaterThanOrderByDrawNumberDesc(int drawNumber, Integer id);

    List<GameAtDraw> findAllByDrawNumberAndIdGreaterThan(int drawNumber, Integer id);

    List<GameAtDraw> findAllByTournamentNameOrderByIdDesc(String tournamentName);



}
