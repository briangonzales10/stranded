package com.game;

import com.game.world.gameWorld;
import com.game.world.location;

import java.util.Arrays;
import java.util.HashMap;

public class game {
    public static void main(String[] args) {
        //testing for game world
        gameWorld game = new gameWorld();

        HashMap<String, location> planet1 = game.getPlanet1();

        System.out.println(planet1.get("Frozen Tundra").getDescription());
        System.out.println(planet1.get("Frozen Tundra").getDirections());
        System.out.println(planet1.get("Crater").getDirections());
        System.out.println(planet1.get("Crater").getHiddenItems());
        System.out.println(planet1.get("Crater").getItems());
    }
}

