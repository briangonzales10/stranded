package com.game.world;

import java.util.HashMap;


public class gameWorld {

    //Field for each planet
    private HashMap<String, location> planet1;

    public gameWorld() {
        planet1 = new HashMap<>();

        planet1.put("Crash Site", new location(1,"Crash Site", "You see your crashed ship with obvious signs of damage. You'll need to find tools to fix them. You take a look around and see paths to the North, East and South.",
                "Tundra", "Beach", "Mountains", null,null, "pistol"));
        planet1.put("Frozen Tundra", new location(2, "Frozen Tundra","Temperatures quickly dropped and now you're in the middle of a frozen tundra wasteland.  You don't see much around you except a barely visible path to the west",
                null, null, "Crash Site", "Crater", "shovel",null));
        planet1.put("Crater", new location(3, "Crater", "You fall into a large, but shallow crater.  You notice some plastic crates with some Tools sticking out.  Maybe you can fix your ship with it.  You also see some vegetation starting to grow on one end of the crater",
                null, "Frozen Tundra", "Jungle", null, "tools",null));

    }

    //Getters for planets
    public HashMap<String, location> getPlanet1() {
        return planet1;
    }

    @Override
    public String toString() {
        return "gameWorld{" +
                "planet1=" + planet1 +
                '}';
    }
}
