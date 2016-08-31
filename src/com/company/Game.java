package com.company;


import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game {

    private RuleBook rules;
    private Oiram oiram;
    private Ground ground;
    private Obstacle obstacle;
    private Wall[] walls = new Wall[3];
    private List<Obstacle> allObstacles;
    private List<Entity> entities;

    public Game(Oiram oiram, Terminal terminal) {
        rules = new RuleBook();
        entities = new ArrayList<>();
        allObstacles = new ArrayList<>();
        this.oiram = oiram;
        //      entities.add(this.oiram);
        this.ground = new Ground(terminal);
        entities.add(this.ground);
        this.obstacle = new Obstacle(new Coordinates(10, 10));
        entities.add(this.obstacle);
        allObstacles.add(this.obstacle);

        walls[0] = new Wall(true, false);
        walls[1] = new Wall(false, true);
        walls[2] = new Wall(false, false);
        for (int i = 0; i < walls.length; i++) {
            entities.add(walls[i]);
        }
    }

    public RuleBook getRuleBook() {
        return rules;
    }

    public void updateState(Terminal terminal) throws InterruptedException {
        Move move = new Move(this);
        move.moveAll(terminal);
        removeObstacles();
        handleObstacles();
    }

    private void removeObstacles() {
        for (Iterator<Obstacle> iterator = allObstacles.iterator(); iterator.hasNext(); ) {
            Obstacle obs = iterator.next();
            for (Pixel pix : obs.blueprint()) {
                if (-10 > pix.getX()) {
                    iterator.remove();
                    entities.remove(obs);
                    break;
                }
            }
        }

    }
    private void handleObstacles() {
        Random rnd = new Random();
        int myRand = rnd.nextInt(10);
        boolean anotherRand = rnd.nextBoolean();
        if (myRand < 3) {
            if(!anotherRand) {
                for (int i = 0; i < myRand; i++) {
                    if (allObstacles.size() < 40) {
                        this.obstacle = new Obstacle(new Coordinates(10, 10));
                        entities.add(this.obstacle);
                        allObstacles.add(this.obstacle);
                    }
                }
            }
        }
    }

    public Wall[] getWalls() {
        return walls;
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

    public List<Entity> getEntities() {
        return entities;
    }

    public boolean gameOver() {
        return rules.isGameover();
    }

    public List<Obstacle> getAllObstacles() {
        return allObstacles;
    }
}
