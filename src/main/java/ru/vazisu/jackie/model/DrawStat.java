package ru.vazisu.jackie.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * DrawStat.
 *
 * @author Pavel_Datunashvili
 */
@Data
@Accessors(chain = true)
public class DrawStat {
    private int drawNumber;
    private int homeWin;
    private int draw;
    private int awayWin;

    private int fonPull;
    private int fonMiddle;
    private int fonUnPull;

    private int manPull;
    private int manMiddle;
    private int manUnPull;
}
