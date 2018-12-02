package ru.vazisu.jackie.xlsxmodel;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class XLSXDraw {

    private int number;
    private Date date;

    private List<XLSXGame> gameList = new ArrayList<>();
}
