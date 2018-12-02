package ru.vazisu.jackie.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "draws")
public class GameAtDraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int drawNumber;
    private Date date;
    private int tournamentType;
    private String tournamentName;
    private String homeTeamName;
    private String awayTeamName;
    private int homeScore;
    private int awayScore;
    private double fonHome;
    private double fonDraw;
    private double fonAway;
    private double manHome;
    private double manDraw;
    private double manAway;

    public GameAtDraw() {
    }
}
