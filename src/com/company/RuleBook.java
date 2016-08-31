package com.company;

import java.util.List;

/**
 * Created by Administrator on 2016-08-31.
 */
public class RuleBook {
    boolean gameover = false;


    public boolean canMove(Entity toMove, List gameEntity, String direction) {
        System.out.println(direction);
        if (direction.equals("Left")) {
            return !isOnLeft(toMove, gameEntity);
        }
        else if (direction.equals("Up")) {
            return !isAbove(toMove, gameEntity);
        }
        else if (direction.equals("Right")) {
            return !isOnRight(toMove, gameEntity);
        }
        else if (direction.equals("Down")) {
            return !isBelow(toMove, gameEntity);
        }
        else
            return false;
    }

    private boolean isOnLeft(Entity aniToCheck, List<Entity> gameEntity) {
        for (Pixel pAni : aniToCheck.getShape()) {
            for (Entity eachEntity : gameEntity) {
                for (Pixel pEntity : eachEntity.getShape()) {
                    if (pEntity.getY() == pAni.getY() && pEntity.getX() - 1 == pAni.getX()) {
                        gameover = true;
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private boolean isOnRight(Entity aniToCheck, List<Entity> gameEntity) {
        for (Pixel pAni : aniToCheck.getShape()) {
            for (Entity eachEntity : gameEntity) {
                for (Pixel pEntity : eachEntity.getShape()) {
                    if (pEntity.getY() == pAni.getY() && pEntity.getX() + 1 == pAni.getX()) {
                        gameover = true;
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private boolean isAbove(Entity aniToCheck, List<Entity> gameEntity) {
        for (Pixel pAni : aniToCheck.getShape()) {
            for (Entity eachEntity : gameEntity) {
                for (Pixel pEntity : eachEntity.getShape()) {
                    if (pEntity.getY() - 1 == pAni.getY() && pEntity.getX() == pAni.getX()) {
                        gameover = true;
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private boolean isBelow(Entity aniToCheck, List<Entity> gameEntity) {
        for (Pixel pAni : aniToCheck.getShape()) {
            for (Entity eachEntity : gameEntity) {
                for (Pixel pEntity : eachEntity.getShape()) {
                    if (pEntity.getY() + 1 == pAni.getY() && pEntity.getX() == pAni.getX()) {
                        gameover = true;
                       return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean isGameover() {
        return gameover;
    }
}
