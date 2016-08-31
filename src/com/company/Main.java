package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF-8"));
        terminal.enterPrivateMode();
        Oiram oiram = new Oiram(new Coordinates(5, 5));
        Game game = new Game(oiram, terminal);

        do {
            updateScreen(terminal, game); //game,
            game.updateState(terminal);
       } while (!game.gameOver());
        terminal.clearScreen();
        new PrintToTerminal(new GameOverScreen(new Coordinates(10,10)), terminal).print();
    }

    public static void updateScreen(Terminal terminal, Game game) { //Game game,
        terminal.setCursorVisible(false);
        terminal.clearScreen();

        new PrintToTerminal(game.getOiram(), terminal).print();
        new PrintToTerminal(game.getGround(), terminal).print();
        for (Obstacle obs : game.getAllObstacles()) {
            new PrintToTerminal(obs, terminal).print();
        }
        for (Wall w : game.getWalls()) {
            new PrintToTerminal(w, terminal).print();
        }
    }
}
