package ru.vazisu.jackie.xlsxparser;

import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.vazisu.jackie.xlsxmodel.XLSXDraw;
import ru.vazisu.jackie.xlsxmodel.XLSXGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XLSXParser {
    private String fileName;
    private FileInputStream fileInputStream;
    private XSSFWorkbook workBook;
    private XSSFSheet sheet;
    @Getter
    @Setter
    private Map<Integer, XLSXDraw> map = new HashMap<>();
    private List<XLSXGame> gameList;

    public XLSXParser() {
    }

    public XLSXParser(String fileName) throws IOException {
        this.fileName = fileName;

        getFile();
        getWorkBook();
        getSheet();
        getDrawMap();
//        printMap();

    }

    private void getFile() throws FileNotFoundException {
        File file = new File(fileName);
        fileInputStream = new FileInputStream(file);
    }

    private void getWorkBook() throws IOException {
        workBook = new XSSFWorkbook(fileInputStream);
    }

    private void getSheet(){
        sheet = workBook.getSheetAt(0);
    }

    private Map<Integer, XLSXDraw> getDrawMap() {
        for (Row row : sheet){

            XLSXDraw draw = new XLSXDraw();
            gameList = new ArrayList<>();

            draw.setNumber((int) Math.round(row.getCell(0).getNumericCellValue()));
            draw.setDate( row.getCell(1).getDateCellValue());

            int number = 0;

            for (int i = 34; i < 175; i = i+10){
                number++;
                XLSXGame game = new XLSXGame();
                game.setNumberAtDraw(number);
                game.setTournamentType(row.getCell(i).getStringCellValue());
                game.setTournamentName(row.getCell(i).getStringCellValue());
                game.setHomeTeam(row.getCell(i+1).getStringCellValue());
                game.setAwayTeam(row.getCell(i+1).getStringCellValue());
                game.setHomeTeamScore(row.getCell(i+2).getStringCellValue());
                game.setAwayTeamScore(row.getCell(i+2).getStringCellValue());
                game.setFonHome((int) Math.round(row.getCell(i+4).getNumericCellValue()));
                game.setFonDraw((int) Math.round(row.getCell(i+6).getNumericCellValue()));
                game.setFonAway((int) Math.round(row.getCell(i+8).getNumericCellValue()));
                game.setManHome(row.getCell(i+5).getNumericCellValue());
                game.setManDraw(row.getCell(i+7).getNumericCellValue());
                game.setManAway(row.getCell(i+9).getNumericCellValue());
                gameList.add(game);
            }
            draw.setGameList(gameList);

            map.put(row.getRowNum(), draw);

        }
        return map;
    }

    private void printMap(){
        map.keySet().stream()
                .filter( (index) -> map.get(index).getNumber() >0)
                .forEach( (index) -> {
                    System.out.println(map.get(index).getNumber()
                            + " " + map.get(index).getDate()+ " ") ;
                    map.get(index).getGameList().forEach( (game -> {
                        System.out.println(game.getHomeTeam() + " " + " " +
                                game.getHomeTeamScore());
                    }));
                });
    }
}
