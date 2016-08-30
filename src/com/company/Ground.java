package com.company;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Ground extends NonAnimated {

    public static  int groundLevel;
    public static  int groundWidth;


    public Ground(Terminal terminal) {
        super();
        groundLevel = terminal.getTerminalSize().getRows()-5;
        groundWidth = terminal.getTerminalSize().getColumns();
        setShape(blueprint());
    }

    public List<Pixel> blueprint() {
        List<Pixel> tempList = new ArrayList<>();
        for (int i = 0; i <groundWidth; i++){
            tempList.add(new Pixel(i,groundLevel,'█'));
        }
        return tempList;
    }


}
