package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Obstacle extends Animated implements Draw {
    public Obstacle(Coordinates coord) {

        super(coord);
        setShape(blueprint());

    }
    public List<Pixel> blueprint() {
        List<Pixel> tempList = new ArrayList<>();
        Random rnd = new Random();
        int ourRandom = rnd.nextInt(3) + 2;
        for (int i = 0; i < ourRandom; i++){
            tempList.add(new Pixel(i+10,Ground.groundLevel-1,'X')); //▓Ground.groundWidth
        }
        return tempList;
    }

}
