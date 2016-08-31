package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Created by Roberto Angius on 2016-08-30.
 */
public class Move {

    private Game game;
    private char[] keyInput = {'L', 'U', 'R'};

    public Move(Game game) {
        this.game = game;
    }

    public void move(Entity entity, Coordinates relCoord) {
        entity.setCoord(new Coordinates(entity.getCoord().getX() + relCoord.getX(), entity.getCoord().getY() + relCoord.getY()));
        for (Pixel p : entity.getShape()) {
            p.setX(p.getX() + relCoord.getX());
            p.setY(p.getY() + relCoord.getY());
        }
    }

    private char getKeyInput(int key) {
        return keyInput[key];
    }

    public Coordinates getPlayerRelCord(Terminal terminal) throws InterruptedException {
        Key key;
        LocalTime tm = LocalTime.now();
        Coordinates tempCoord = new Coordinates(0, 0);
        do {
            Thread.sleep(5);
            key = terminal.readInput();
            if (key != null) {

                char keyKind = key.getCharacter();

                for (int j = 0; j < 3; j++) {
                    if (getKeyInput(j) == keyKind) {
                        switch (j) {
                            case 0:
                                tempCoord = new Coordinates(-3, 0);
                                break;
                            case 1:
                                tempCoord = new Coordinates(1, -3);
                                break;
                            case 2:
                                tempCoord = new Coordinates(4, 0);
                        }
                    }
                }

                System.out.println(key.getCharacter() + " " + key.getKind());
            }

        } while (1 > (Duration.between(tm, LocalTime.now()).getNano() / 300000000)); //Seconds before the game updates
        return tempCoord;
    }

    public void moveAll(Terminal terminal) throws InterruptedException {
        Coordinates temp = getPlayerRelCord(terminal);
        int x = temp.getX();
        int y = temp.getY();


        if (x == 0 && y==0){
            if (game.getRuleBook().canMove(game.getOiram(), game.getEntities(), "Left")) {
                move(game.getOiram(), new Coordinates(-1, 0));
            }
            if (game.getRuleBook().canMove(game.getOiram(), game.getEntities(), "Down")) {
                move(game.getOiram(), new Coordinates(0, 1));
            }
        }else {
            x--;
            y++;
            while (y != 0) {
                if (y > 0) {
                    if (game.getRuleBook().canMove(game.getOiram(), game.getEntities(), "Down")) {
                        move(game.getOiram(), new Coordinates(0, 1));
                    }
                    y--;
                } else if (y < 0) {
                    if (game.getRuleBook().canMove(game.getOiram(), game.getEntities(), "Up")) {
                        move(game.getOiram(), new Coordinates(0, -1));
                    }
                    y++;
                }

            }
            while (x != 0) {
                if (x > 0) {
                    if (game.getRuleBook().canMove(game.getOiram(), game.getEntities(), "Right")) {
                        move(game.getOiram(), new Coordinates(1, 0));

                    }
                    x--;
                } else if (x < 0) {
                    if (game.getRuleBook().canMove(game.getOiram(), game.getEntities(), "Left")) {
                        move(game.getOiram(), new Coordinates(-1, 0));
                    }
                    x++;
                }

            }
        }



        for (Obstacle obs : game.getAllObstacles()) {
            move(obs, new Coordinates(-1, 0));
        }

    }


}
