package com.company;


import com.googlecode.lanterna.terminal.Terminal;

public class Game {

    private Oiram oiram;
    private Ground ground;
    private Obstacle obstacle;



    public Game(Oiram oiram, Terminal terminal) {
        this.oiram = oiram;
        this.ground = new Ground(terminal);
        this.obstacle = new Obstacle(new Coordinates(10,10));
    }

    public void updateState(Terminal terminal) throws InterruptedException {
        Move move = new Move(this);
        move.moveAll(terminal);
    }


    public Oiram getOiram() {
        return oiram;
    }

    public Ground getGround() {
        return ground;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
}
