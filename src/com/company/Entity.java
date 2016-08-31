package com.company;

import java.util.ArrayList;
import java.util.List;


public class Entity{
    private Coordinates coord;
    private List<Pixel> shape;

    public Entity() {
        this.shape = new ArrayList<>();
    }


    public Entity(Coordinates coord) {
        this.coord = coord;
        this.shape = new ArrayList<>();
    }

    public List<Pixel> getShape() {
        return shape;
    }

    public void setShape(List<Pixel> shape) {
        this.shape = shape;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

}
