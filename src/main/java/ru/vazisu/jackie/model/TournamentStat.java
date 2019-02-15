package ru.vazisu.jackie.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * TournamentStat.
 *
 * @author Pavel_Datunashvili
 */
@Data
@Accessors(chain = true)
public class TournamentStat {
    private int drawNumber;
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private int homeWin;
    private int draw;
    private int awayWin;
    private int fonPull;
    private int fonMiddle;
    private int fonUnPull;

    private int manPull;
    private int manMiddle;
    private int manUnPull;
}
