package ru.vazisu.jackie.model;

import lombok.Data;

/**
 * GameAnalyzer.
 *
 * @author Pavel_Datunashvili
 */
@Data
public class GameAnalyzer {

    private String tournamentName;
    private String homeTeamName;
    private String awayTeamName;

    private double fonHome;
    private double fonDraw;
    private double fonAway;
    private double manHome;
    private double manDraw;
    private double manAway;
}
