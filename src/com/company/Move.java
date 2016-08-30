package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Roberto Angius on 2016-08-30.
 */
public class Move {

    private Game game;
    private char[] keyInput = {'L', 'U', 'R'};
    private Coordinates movement = new Coordinates(0,0);

    public Move(Game game) {
        this.game = game;
    }

    public void move(Animated animated, Coordinates relCoord) {
        animated.setCoord(new Coordinates(animated.getCoord().getX() + relCoord.getX(), animated.getCoord().getY() + relCoord.getY() ));
        for (Pixel p : animated.getShape()) {
            p.setX(p.getX() + relCoord.getX());
            p.setY(p.getY() + relCoord.getY());
        }
    }

    private char getKeyInput(int key){
        return keyInput[key];
    }

    public Coordinates getPlayerRelCord(Terminal terminal) throws InterruptedException {
        Key key;
        LocalTime tm = LocalTime.now();
        Coordinates tempCoord = new Coordinates(0,0);
        do {
            Thread.sleep(5);
            key = terminal.readInput();
            if (key != null) {

                char keyKind = key.getCharacter();

                for (int j = 0; j < 3; j++) {
                    if (getKeyInput(j) == keyKind) {
                        switch (j) {
                            case 0:
                                tempCoord = new Coordinates(-1,0);
                                break;
                            case 1:
                                tempCoord = new Coordinates(1,-3);
                                break;
                            case 2:
                                tempCoord = new Coordinates(4,0);
                        }
                    }

                }

                System.out.println(key.getCharacter() + " " + key.getKind());
            }

        } while (1 > (Duration.between(tm, LocalTime.now()).getNano() / 300000000)); //Seconds before the game updates
        return tempCoord;
    }

    public void moveAll(Terminal terminal) throws InterruptedException {
        if (isOnGround(game.getOiram(),game.getGround())){
            move(game.getOiram(), new Coordinates(-1,0));
        }else {
            move(game.getOiram(), new Coordinates(-1,1));
        } //Momentum)
        move(game.getObstacle(), new Coordinates(-1,0));
        move(game.getOiram(), getPlayerRelCord(terminal)); //Knapptryckning


    }

    private boolean isOnGround(Oiram oiram, Ground ground) {
        for (Pixel pOiram : oiram.getShape()) {
            for (Pixel pGround : ground.getShape()) {
                if (pGround.getY()-1 == pOiram.getY()) {
                    return true;
                }
            }
        }
        return false;
    }
}
