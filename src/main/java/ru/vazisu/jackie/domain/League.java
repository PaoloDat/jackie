package ru.vazisu.jackie.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * League.
 *
 * @author Pavel_Datunashvili
 */
@Data
@Entity
@Accessors(chain = true)
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String leagueName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/mm/yyyy")
    private LocalDate date;
    private String homeTeamName;
    private String awayTeamName;
    private int homeScore;
    private int awayScore;
    private int halfHomeScore;
    private int halfAwayScore;
    private String referee;
    private int homeTeamShotOnTarget;
    private int awayTeamShotOnTarget;
    private int homeTeamCorner;
    private int awayTeamCorner;
    private int homeTeamOffside;
    private int awayTeamOffside;
    private int homeTeamYellowCard;
    private int awayTeamYellowCard;
    private int homeTeamRedCard;
    private int awayTeamRedCard;
    private double homeWinOdd;
    private double drawOdd;
    private double awayWinOdd;
}
