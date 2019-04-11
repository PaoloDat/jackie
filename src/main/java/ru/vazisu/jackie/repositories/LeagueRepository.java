package ru.vazisu.jackie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vazisu.jackie.domain.League;

/**
 * LeagueRepository.
 *
 * @author Pavel_Datunashvili
 */
@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
}

