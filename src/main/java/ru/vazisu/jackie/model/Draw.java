package ru.vazisu.jackie.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Draw.
 *
 * @author Pavel_Datunashvili
 */
@Data
public class Draw {
    private Long number;
    private List<GameAtDraw>gameList = new ArrayList<>();
}
