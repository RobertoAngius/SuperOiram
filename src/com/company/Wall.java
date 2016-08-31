package com.company;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public class Wall extends Entity implements Draw {

    private boolean left = true;
    private boolean roof = false;

    public Wall(boolean isLeft, boolean isRoof) {
        super();
        if (isRoof) {
            roof = true;
            makeBlueprint(new Coordinates(0,0));
        }
        else if (isLeft) {
            makeBlueprint(new Coordinates(0,1));
        }
        else {
            left = false;
            makeBlueprint(new Coordinates(Ground.groundWidth,1));
        }
    }

    public void makeBlueprint(Coordinates centerCoord) {
        List<Pixel> tempList = new ArrayList<>();
        if (centerCoord.getY() == 1) {
            for (int i = 0; i < Ground.groundLevel; i++){
                tempList.add(new Pixel(centerCoord.getX(),i,'█'));
            }
        }
        else {
            for (int i = 0; i < Ground.groundWidth; i++) {
                tempList.add(new Pixel(i, 0, '█'));
            }
        }
        setShape(tempList);
    }

    public List<Pixel> blueprint() {
        return getShape();
    }

}
