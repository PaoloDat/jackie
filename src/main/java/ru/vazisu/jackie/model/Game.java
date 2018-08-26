package ru.vazisu.jackie.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    private int numberAtDraw;

    private String tournamentType;
    private String tournamentName;

    private String homeTeam;
    private String awayTeam;
    private String homeTeamScore;
    private String awayTeamScore;

    private int fonHome;
    private int fonDraw;
    private int fonAway;

    private double manHome;
    private double manDraw;
    private double manAway;


}
