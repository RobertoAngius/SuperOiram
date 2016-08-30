package com.company;

import java.util.Arrays;

/**
 * Created by Roberto Angius on 2016-08-29.
 */
public class Coordinates {
    private int x;
    private int y;

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public void add(Coordinates coordtoAdd) {
        x += coordtoAdd.getX();
        y += coordtoAdd.getY();
    }
    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
