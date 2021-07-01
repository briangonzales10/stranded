package com.game;

import com.game.player.Player;
import com.game.world.gameWorld;
import com.game.world.location;
import com.game.textparser.UserInput;
import com.game.startmenu.*;

import java.util.HashMap;

public class game {
    public static void main(String[] args) {
        //testing for game world
        gameWorld game = new gameWorld();

        HashMap<String, location> planet1 = game.getPlanet1();

        System.out.println(planet1.get("Frozen Tundra").getDescription());
        System.out.println(planet1.get("Frozen Tundra").getDirections());
        System.out.println(planet1.get("Crater").getDirections());

        //Clinton Tests
        String playerName = UserInput.setPlayerName();
        System.out.println("Welcome Commander " + playerName);

        String[] actionTest = UserInput.action();
        System.out.println("The action you entered is: " + actionTest[0] + " " + actionTest[1]);

        // David Test
        StartMenu game2 = new StartMenu();

        StartMenu.entCont();

        //Clint's player test
        Player player1 = new Player();


    }
}

