package ru.vazisu.jackie.parser;

import ru.vazisu.jackie.model.Draw;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class parserTest {



    public static void main(String[] args) throws IOException {
        Map<Integer, Draw> map;
        XLSXParser xlsxParser = new XLSXParser("C:/AppJava/jackie/src/main/resources/fondb/test1.xlsx");
        map = xlsxParser.getMap();
        System.out.println(map.size());
    }
}
