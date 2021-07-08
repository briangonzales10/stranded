package com.game.world;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.items.Item;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;



public class gameWorld {
    private static String currentLocation = "Crash Site";
    private static String previousLocation = "Crash Site";

    //Fields for Game Assets
    private static HashMap<String, location> planet1;
    private static HashMap<String, ArrayList<Item>> gameItems;
    private static HashMap<String, ArrayList<Item>> hiddenItems;

    public gameWorld() throws IOException {
        createGameAssets();
    }


// Methods

    private void createGameAssets() throws IOException{
        //Load our locations from planet1.json file into array of location objects
        //File directory = new File("./");
        //System.out.println(directory.getAbsolutePath());

        byte[] locationData = Files.readAllBytes(Paths.get("src/com/world/planet1.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        location[] location = objectMapper.readValue(locationData, location[].class);

        //load our planet Hashmap with location objects
        planet1 = new HashMap<>();
        for (location loc: location ) {
            planet1.put(loc.getName(), loc);
        }
        //Create Array of Items from JSON
        byte[] itemData = Files.readAllBytes(Paths.get("src/com/game/items/items.json"));
        Item[] itemsArray = objectMapper.readValue(itemData,Item[].class);

        //Create our hashmap to hold our Array List for game items
        int numberOfLocations = locationData.length;
        gameItems = new HashMap<>(numberOfLocations);

        //Create Array List for each location
        for (location loc: location) {
            gameItems.put(loc.getName(),new ArrayList<Item>());
        }

        //Load our Items into their respective location ArrayList

        for (Item item: itemsArray) {
            //Looks up the correct ArrayList based on item location in Hashmap, and adds Item element to the ArrayList
            gameItems.get(item.getLocation()).add(item);
        }

        //Create Hidden Items hashmap
        byte[] hiddenItemData = Files.readAllBytes(Paths.get("src/com/game/items/hidden.json"));
        Item[] hiddenItemsArray = objectMapper.readValue(hiddenItemData,Item[].class);

        hiddenItems = new HashMap<>(numberOfLocations);
        for (location loc: location) {
            hiddenItems.put(loc.getName(),new ArrayList<Item>());
        }
        for (Item hiddenitem : hiddenItemsArray) {
            hiddenItems.get(hiddenitem.getLocation()).add(hiddenitem);
        }
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


    public static void addGameItem(String loc, Item name) {
        if (loc != null && !loc.equals("")) {
            gameItems.get(loc).add(name);
        }

    }

    public static void removeGameItem(String loc, Item name) {
        if (loc != null && !loc.equals("")) {
            gameItems.get(loc).remove(name);
        }
    }

    public static void removeHiddenItem(String loc, Item name) {
        if (loc != null && !loc.equals("")) {
            hiddenItems.get(loc).remove(name);
        }
    }

    public static StringBuilder getItemsByLocation(String loc) {
        if (loc == null || loc.equals("")) {
            return null;
        }

        ArrayList<Item> itemsArray = gameItems.get(loc);
        StringBuilder LocationItems = new StringBuilder();

        for (Item item:itemsArray) {
            LocationItems.append(item.getItemName()).append(" ");
        }


        return LocationItems;
    }

    //Getters & Setters for planets & items
    public static HashMap<String, location> getPlanet1() {
        return planet1;
    }

    public static HashMap<String, ArrayList<Item>> getGameItems() {
        return gameItems;
    }

    public static HashMap<String, ArrayList<Item>> getHiddenItems() {
        return hiddenItems;
    }


    public static String getCurrentLocation() {
        return currentLocation;
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
