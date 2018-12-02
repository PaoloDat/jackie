package ru.vazisu.jackie.xlsxparser;

import ru.vazisu.jackie.xlsxmodel.XLSXDraw;

import java.io.IOException;
import java.util.Map;

public class parserTest {



    public static void main(String[] args) throws IOException {
        Map<Integer, XLSXDraw> map;
        XLSXParser xlsxParser =
                new XLSXParser("src/main/resources/fondb/test.xlsx");
        map = xlsxParser.getMap();
        System.out.println(map.size());
    }
}
