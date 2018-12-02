package ru.vazisu.jackie.bootstarp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.vazisu.jackie.model.GameAtDraw;
import ru.vazisu.jackie.repositories.GameAtDrawRepository;
import ru.vazisu.jackie.xlsxmodel.XLSXDraw;
import ru.vazisu.jackie.xlsxparser.XLSXParser;

import java.io.IOException;
import java.util.Map;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private GameAtDrawRepository gameAtDrawRepository;

    public DevBootstrap(GameAtDrawRepository gameAtDrawRepository) {
        this.gameAtDrawRepository = gameAtDrawRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        try {
//            fillGameData();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void initData(){
        GameAtDraw gameAtDraw = new GameAtDraw();

        gameAtDrawRepository.save(gameAtDraw);

    }

    private void fillGameData() throws IOException {
        XLSXParser xlsxParser =
                new XLSXParser("src/main/resources/fondb/test.xlsx");
        Map<Integer, XLSXDraw> map = xlsxParser.getMap();

        map.keySet()
                .forEach( index -> {
                    map.get(index).getGameList().stream()
                            .filter( game -> !game.getHomeTeamScore().equals("")
                                    &&
                                    !game.getHomeTeamScore().equals("отмена"))
                            .forEach(game -> {
                                GameAtDraw gameAtDraw = new GameAtDraw();
                                gameAtDraw.setDrawNumber(map.get(index).getNumber());
                                gameAtDraw.setDate(map.get(index).getDate());
                                if (game.getTournamentType().contains("Футбол")){
                                    gameAtDraw.setTournamentType(1);
                                } else {
                                    gameAtDraw.setTournamentType(0);
                                }
                                gameAtDraw.setTournamentName(game.getTournamentName());

                                String[] teamNames = game.getHomeTeam().split(" - ");
                                gameAtDraw.setHomeTeamName(teamNames[0]);
                                gameAtDraw.setAwayTeamName(teamNames[1]);

                                String[] teamScores = game.getHomeTeamScore().split(":");
                                gameAtDraw.setHomeScore(Integer.valueOf(teamScores[0]));
                                gameAtDraw.setAwayScore(Integer.valueOf(teamScores[1]));

                                gameAtDraw.setFonHome(game.getFonHome());
                                gameAtDraw.setFonDraw(game.getFonDraw());
                                gameAtDraw.setFonAway(game.getFonAway());

                                gameAtDraw.setManHome(game.getManHome());
                                gameAtDraw.setManDraw(game.getManDraw());
                                gameAtDraw.setManAway(game.getManAway());
                                gameAtDrawRepository.save(gameAtDraw);
                            });
                });

    }
}