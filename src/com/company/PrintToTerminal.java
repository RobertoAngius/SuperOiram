package com.company;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Roberto Angius on 2016-08-30.
 */
public class PrintToTerminal {

    Draw draw;
    Terminal terminal;

    public PrintToTerminal(Draw draw, Terminal terminal) {
        this.draw = draw;
        this.terminal = terminal;
    }

    public void print() {
        for (Pixel pixel : draw.blueprint()) {
            terminal.moveCursor(pixel.getX(), pixel.getY());
            terminal.putCharacter(pixel.getAppearence());
        }
    }
}
