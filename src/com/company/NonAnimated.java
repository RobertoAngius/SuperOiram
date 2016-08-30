package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roberto Angius on 2016-08-29.
 */
public abstract class NonAnimated {
    private Coordinates coord;
    private List<Pixel> shape;

    public NonAnimated() {
        this.shape = new ArrayList<>();
    }

    public void setShape(List<Pixel> shape) {
        this.shape = shape;
    }
    public List<Pixel> getShape() {
        return shape;
    }
    public void addShape(Pixel pixel){
        shape.add(pixel);
    }


}
