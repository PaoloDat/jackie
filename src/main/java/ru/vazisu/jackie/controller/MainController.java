package ru.vazisu.jackie.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vazisu.jackie.model.DrawAnalyzer;
import ru.vazisu.jackie.model.DrawStat;
import ru.vazisu.jackie.model.GameAnalyzer;
import ru.vazisu.jackie.model.GameAtDraw;
import ru.vazisu.jackie.model.TournamentStat;
import ru.vazisu.jackie.repositories.GameAtDrawRepository;
import ru.vazisu.jackie.service.DrawStatService;
import ru.vazisu.jackie.service.TournamentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MainController.
 *
 * @author Pavel_Datunashvili
 */
@Slf4j
@Controller
@AllArgsConstructor
@SuppressWarnings("Duplicates")
public class MainController {

    private DrawStatService drawService;
    private GameAtDrawRepository repository;
    private TournamentService tournamentService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("size", new DrawAnalyzer());
        model.addAttribute("gamestat", new GameAnalyzer());
        return "index";
    }

    @PostMapping("/drawstat")
    public String getDrawStat(@ModelAttribute DrawAnalyzer drawAnalyzer, Model model) {
        int lastDrawNumber = repository.findTopByOrderByIdDesc().getDrawNumber();

        List<DrawStat> drawStats = new ArrayList<>();

        for (int i = 0; i < drawAnalyzer.getSize(); i++) {

            List<GameAtDraw> allByDrawNumber = repository.findAllByDrawNumberAndIdGreaterThan(lastDrawNumber - i, 14735);
            if (!allByDrawNumber.isEmpty()) {
                drawStats.add(drawService.getDrawStat(allByDrawNumber));
            }
        }
        model.addAttribute("drawstat", drawStats);

        return "drawstat";
    }

    @PostMapping("/gamestat")
    public String getGameStat(@ModelAttribute GameAnalyzer gameAnalyzer, Model model) {

        List<GameAtDraw> allByTournamentName = repository.findAllByTournamentNameOrderByIdDesc(gameAnalyzer.getTournamentName());
        List<TournamentStat> tournamentStats = allByTournamentName.stream()
                .map(t -> tournamentService.getTournamentStat(t))
                .collect(Collectors.toList());

        model.addAttribute("tournamentStats", tournamentStats);

        return "gamestat";
    }

}
