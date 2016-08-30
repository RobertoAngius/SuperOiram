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
        Oiram oiram = new Oiram(new Coordinates(5,5));
        Game game = new Game(oiram,terminal);

        boolean gameOver = false;
       do {
            updateScreen(terminal, game); //game,
            game.updateState(terminal);
           System.out.println(game.getObstacle().getCoord().getX());
        }while (!gameOver);

    }

    public static void updateScreen(Terminal terminal, Game game){ //Game game,
        terminal.setCursorVisible(false);
        terminal.clearScreen();

        //List<Pixel> tempList = new ArrayList<>(oiram.blueprint());

        for (Pixel pixel : game.getOiram().blueprint()) {
            terminal.moveCursor(pixel.getX(), pixel.getY());
            terminal.putCharacter(pixel.getAppearence());
        }
        for (Pixel pixel : game.getGround().blueprint()) {
            terminal.moveCursor(pixel.getX(), pixel.getY());
            terminal.putCharacter(pixel.getAppearence());
        }
        for (Pixel pixel : game.getObstacle().blueprint()) {
            terminal.moveCursor(pixel.getX(), pixel.getY());
            terminal.putCharacter(pixel.getAppearence());
        }

    }
}
