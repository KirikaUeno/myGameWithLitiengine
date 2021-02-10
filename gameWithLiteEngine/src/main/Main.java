package main;

import Objects.Logic;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import ui.InGameScreen;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Game.info().setName("PlayField");
        Game.info().setSubTitle("");
        Game.info().setVersion("v0.0.1");
        Game.init(args);

        ImageIcon icon = new ImageIcon("images/icon.jpg");
        Game.window().setIcon(icon.getImage());
        Game.graphics().setBaseRenderScale(4.001f);
        Resources.load("maps/game.litidata");
        Logic.init();

        //Game.addGameListener(new GameListener() {} );
        Game.world().loadEnvironment("desertMap");
        Game.screens().add(new InGameScreen());

        Game.start();
    }
}
