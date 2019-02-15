package ru.vazisu.jackie.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
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
}
