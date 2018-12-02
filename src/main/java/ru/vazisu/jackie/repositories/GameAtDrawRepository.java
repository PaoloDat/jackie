package ru.vazisu.jackie.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vazisu.jackie.model.GameAtDraw;

public interface GameAtDrawRepository extends CrudRepository<GameAtDraw, Integer> {
}
