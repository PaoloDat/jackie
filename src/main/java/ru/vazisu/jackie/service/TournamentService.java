package ru.vazisu.jackie.service;

import org.springframework.stereotype.Service;
import ru.vazisu.jackie.model.GameAtDraw;
import ru.vazisu.jackie.model.TournamentStat;

/**
 * TornamentService.
 *
 * @author Pavel_Datunashvili
 */
@Service
@SuppressWarnings("Duplicates")
public class TournamentService {

    public TournamentStat getTournamentStat(GameAtDraw game) {

        int homeWin = 0;
        int draw = 0;
        int awayWin = 0;
        int fonPull = 0;
        int fonMiddle = 0;
        int fonUnPull = 0;
        int manPull = 0;
        int manMiddle = 0;
        int manUnPull = 0;

        TournamentStat stat= new TournamentStat()
                .setDrawNumber(game.getDrawNumber())
                .setHomeTeam(game.getHomeTeamName())
                .setAwayTeam(game.getAwayTeamName())
                .setHomeScore(game.getHomeScore())
                .setAwayScore(game.getAwayScore());

        if (game.getHomeScore() > game.getAwayScore()) {
            homeWin++;
            if ((game.getFonHome() > game.getFonAway()) && (game.getFonHome() > game.getFonDraw())) {
                fonPull++;
            } else if((game.getFonHome() < game.getFonAway()) && (game.getFonHome() < game.getFonDraw())) {
                fonUnPull++;
            } else {
                fonMiddle++;
            }

            if ((game.getManHome() > game.getManAway()) && (game.getManHome() > game.getManDraw())) {
                manPull++;
            } else if((game.getManHome() < game.getManAway()) && (game.getManHome() < game.getManDraw())) {
                manUnPull++;
            } else {
                manMiddle++;
            }



        } else if (game.getHomeScore() < game.getAwayScore()) {
            awayWin++;
            if ((game.getFonAway() > game.getFonHome()) && (game.getFonAway() > game.getFonDraw())) {
                fonPull++;
            } else if((game.getFonAway() < game.getFonHome()) && (game.getFonAway() < game.getFonDraw())) {
                fonUnPull++;
            } else {
                fonMiddle++;
            }

            if ((game.getManAway() > game.getManHome()) && (game.getManAway() > game.getManDraw())) {
                manPull++;
            } else if((game.getManAway() < game.getManHome()) && (game.getManAway() < game.getManDraw())) {
                manUnPull++;
            } else {
                manMiddle++;
            }

        } else {
            draw++;
            if ((game.getFonDraw() > game.getFonHome()) && (game.getFonDraw() > game.getFonAway())) {
                fonPull++;
            } else if((game.getFonDraw() < game.getFonHome()) && (game.getFonDraw() < game.getFonAway())) {
                fonUnPull++;
            } else {
                fonMiddle++;
            }

            if ((game.getManDraw() > game.getManHome()) && (game.getManDraw() > game.getManAway())) {
                manPull++;
            } else if((game.getManDraw() < game.getManHome()) && (game.getManDraw() < game.getManAway())) {
                manUnPull++;
            } else {
                manMiddle++;
            }

        }

        return stat.setHomeWin(homeWin)
                .setDraw(draw)
                .setAwayWin(awayWin)
                .setFonPull(fonPull)
                .setFonMiddle(fonMiddle)
                .setFonUnPull(fonUnPull).setManPull(manPull)
                .setManMiddle(manMiddle)
                .setManUnPull(manUnPull);
    }
}
