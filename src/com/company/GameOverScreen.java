package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roberto Angius on 2016-08-31.
 */
public class GameOverScreen extends Entity implements Draw {

    public GameOverScreen(Coordinates coord) {
        super(coord);
        makeBlueprint(new Coordinates(20,5));
    }
    public void makeBlueprint(Coordinates centerCoord){
        List<Pixel> templist = new ArrayList<>();

        List<String> GameoverScreen = new ArrayList<>();
        String GameoverScreen1 = "  ________    _____      _____   ___________\n";
        GameoverScreen.add(GameoverScreen1);
        String GameoverScreen2 = " /  _____/   /  _  \\    /     \\  \\_   _____/\n";
        GameoverScreen.add(GameoverScreen2);
        String GameoverScreen3 = "/   \\  ___  /  /_\\  \\  /  \\ /  \\  |    __)_ \n";
        GameoverScreen.add(GameoverScreen3);
        String GameoverScreen4 = "\\    \\_\\  \\/    |    \\/    Y    \\ |        \\\n";
        GameoverScreen.add(GameoverScreen4);
        String GameoverScreen5 = " \\______  /\\____|__  /\\____|__  //_______  /\n";
        GameoverScreen.add(GameoverScreen5);
        String GameoverScreen6 = "        \\/         \\/         \\/         \\/ \n";
        GameoverScreen.add(GameoverScreen6);
        String GameoverScreen7 = "________   ____   _________________________ \n";
        GameoverScreen.add(GameoverScreen7);
        String GameoverScreen8 = "\\_____  \\  \\   \\ /   /\\_   _____/\\______   \\\n";
        GameoverScreen.add(GameoverScreen8);
        String GameoverScreen9 = " /   |   \\  \\   Y   /  |    __)_  |       _/\n";
        GameoverScreen.add(GameoverScreen9);
        String GameoverScreen10 = "/    |    \\  \\     /   |        \\ |    |   \\\n";
        GameoverScreen.add(GameoverScreen10);
        String GameoverScreen11 = "\\_______  /   \\___/   /_______  / |____|_  /\n";
        GameoverScreen.add(GameoverScreen11);
        String GameoverScreen12 = "        \\/                    \\/         \\/ ";
        GameoverScreen.add(GameoverScreen12);


        int y = 0;
        for (String eachRow: GameoverScreen){
            for (char eachChar = 0; eachChar<eachRow.length();eachChar++){
                templist.add(new Pixel(eachChar + centerCoord.getX(),y + centerCoord.getY(),eachRow.charAt(eachChar)));
            }
            y++;
        }
        setShape (templist);
    }

    public List<Pixel> blueprint() { return getShape();    }

}
