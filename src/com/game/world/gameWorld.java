package com.game.world;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;



public class gameWorld {
    private static String currentLocation = "Crash Site";
    private static String previousLocation = "Crash Site";

    //Field for each planet
    private static HashMap<String, location> planet1;

    public gameWorld() throws IOException {
        //Load our locations from planet1.json file into array of location objects
        byte[] locationData = Files.readAllBytes(Paths.get("src/com/game/world/planet1.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        location[] location = objectMapper.readValue(locationData, location[].class);

        //load our planet Hashmap with location objects
        planet1 = new HashMap<>();
        for (location loc: location ) {
            planet1.put(loc.getName(), loc);
        }

    }

    //Getters for planets
    public static HashMap<String, location> getPlanet1() {
        return planet1;
    }

    public static String getCurrentLocation() {
        return currentLocation;
    }

    public static String getNextLocation(String currentLocationArg, String direction) {
        String nextLocation = "";
        switch (direction.toLowerCase()) {
            case "north":
                nextLocation = planet1.get(currentLocationArg).getNorth();
                break;
            case "east":
                nextLocation = planet1.get(currentLocationArg).getEast();
                break;
            case "south":
                nextLocation = planet1.get(currentLocationArg).getSouth();
                break;
            default:
                nextLocation = planet1.get(currentLocationArg).getWest();
        }
        return nextLocation;
    }

    public static void setCurrentLocation(String newLocation) {
        setPreviousLocation(currentLocation);
        currentLocation = newLocation;

    }

    public static String getPreviousLocation() {
        return previousLocation;
    }

    private static void setPreviousLocation(String previousLocation) {
        gameWorld.previousLocation = previousLocation;
    }

    @Override
    public String toString() {
        return "gameWorld{" +
                "planet1=" + planet1 +
                '}';
    }
}
