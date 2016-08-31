package com.company;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Ground extends Entity implements Draw{

    public static  int groundLevel;
    public static  int groundWidth;

    public Ground(Terminal terminal) {
        super();
        groundLevel = terminal.getTerminalSize().getRows();
        groundWidth = terminal.getTerminalSize().getColumns();
        makeBlueprint(new Coordinates(0,groundLevel));
    }

    public void makeBlueprint(Coordinates centerCoord) {
        List<Pixel> tempList = new ArrayList<>();
        for (int i = 0; i <groundWidth; i++){
            tempList.add(new Pixel(i,centerCoord.getY(),'█'));
        }
        setShape(tempList);
    }

    public List<Pixel> blueprint() {
        return getShape();
    }


}
