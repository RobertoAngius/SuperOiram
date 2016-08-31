package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Obstacle extends Entity implements Draw {
    public Obstacle(Coordinates coord) {

        super(coord);
        makeBlueprint(new Coordinates(Ground.groundWidth, Ground.groundLevel));

    }
    public void makeBlueprint(Coordinates centerCoord) {
        List<Pixel> tempList = new ArrayList<>();
        Random rnd = new Random();
        int ourRandom = rnd.nextInt(8) + 2;
        int ourRandomY = rnd.nextInt(Ground.groundLevel);
        for (int i = 0; i < ourRandom; i++){
            tempList.add(new Pixel(i+centerCoord.getX(),centerCoord.getY()- ourRandomY,'▓')); //▓Ground.groundWidth
        }
        setShape(tempList);
    }
    public List<Pixel> blueprint() {
        return getShape();
    }

}
