package com.game;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.items.Item;
import com.game.player.Player;
import com.game.startmenu.StartMenu;
import com.game.world.gameWorld;
import com.game.world.location;
import com.game.textparser.UserInput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class game {
    public static void main(String[] args) throws IOException {
        //Alien testing
        System.out.println("******ALIENS********");
        Random rand = new Random();

        int count = 11;
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }
        System.out.println(rand.nextInt(10));
        System.out.println("******ALIENS********");




        gameWorld game = new gameWorld();

        //Testing for items
        HashMap<String, ArrayList<Item>> gameItems = gameWorld.getGameItems();
        String itemJSON = new ObjectMapper().writeValueAsString(gameItems);
        System.out.println("******ITEMS********");
        //System.out.println(itemJSON);
        System.out.println("******ITEMS********");

//        //testing for game world
//        // Testing .json to Java Location Objects...
//        byte[] locationData = Files.readAllBytes(Paths.get("src/main/resources/planet1.json"));
//        ObjectMapper objectMapper = new ObjectMapper();
//        location[] location = objectMapper.readValue(locationData, location[].class);
//
//
//
//        HashMap<String, location> testPlanet = new HashMap<>();
//        System.out.println("******");
//        for (location loc: location ) {
//            testPlanet.put(loc.getName(), loc);
//        }
//        //System.out.println(testPlanet);
//        System.out.println("******");
//
//
//
//
//        HashMap<String, location> planet1 = game.getPlanet1();
//
//        //String planetJSON = new ObjectMapper().writeValueAsString(planet1);
//
//
//        //System.out.println(planetJSON);
//        System.out.println("\n");
//        System.out.println(planet1);
//
//        System.out.println("______________________________________________");
//        System.out.println(planet1.get("Frozen Tundra").getDescription());
//        System.out.println(planet1.get("Frozen Tundra").getDirections());
//        System.out.println(planet1.get("Crater").getDirections());

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

