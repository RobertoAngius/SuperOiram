package com.company;

/**
 * Created by Roberto Angius on 2016-08-30.
 */
public class Pixel extends Coordinates {
    private char Appearence = 'X';

    public Pixel(char appearence) {
        Appearence = appearence;
    }

    public Pixel(int x, int y, char appearence) {
        super(x, y);
        Appearence = appearence;
    }

    public char getAppearence() {
        return Appearence;
    }

    public void setAppearence(char appearence) {
        Appearence = appearence;
    }
}
