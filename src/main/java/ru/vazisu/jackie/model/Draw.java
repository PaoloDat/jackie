package ru.vazisu.jackie.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Draw {

    private int number;
    private Date date;

    private List<Game> gameList = new ArrayList<>();
}
