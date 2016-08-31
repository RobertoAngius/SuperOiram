package com.company;

import java.util.ArrayList;
import java.util.List;


public class Oiram extends Entity implements Draw {

    private boolean dead = false;

    public Oiram(Coordinates coord) {
        super(coord);
        makeBlueprint(coord);
    }

    public void makeBlueprint(Coordinates centerCoord) {
        List<Pixel> templist = new ArrayList<>();
        templist.add(new Pixel(getCoord().getX(), getCoord().getY(),'█'));
        templist.add(new Pixel(getCoord().getX(), getCoord().getY() - 1,'∞'));
        templist.add(new Pixel(getCoord().getX(), getCoord().getY() - 2,'▄'));
        templist.add(new Pixel(getCoord().getX(), getCoord().getY() + 1,'╚'));
        templist.add(new Pixel(getCoord().getX() + 1, getCoord().getY(),'┘'));
        templist.add(new Pixel(getCoord().getX() - 1, getCoord().getY(),'┌'));
        setShape( templist);
    }

    public List<Pixel> blueprint() {
        return getShape();
    }
}
