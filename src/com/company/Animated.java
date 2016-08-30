package com.company;

import java.util.ArrayList;
import java.util.List;


public class Animated {
    private Coordinates coord;
    private List<Pixel> shape;

    public Animated() {
        this.shape = new ArrayList<>();
    }


    public Animated(Coordinates coord) {
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
