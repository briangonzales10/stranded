package com.game;

import com.game.player.Player;
import com.game.startmenu.StartMenu;
import com.game.textparser.UserInput;
import com.game.world.gameWorld;
import com.game.world.location;

import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        boolean isRunning = true;
        StartMenu start = new StartMenu();
        gameWorld ourGame = new gameWorld();
        HashMap<String, location> planet1 = ourGame.getPlanet1();

        boolean Run = true;
        Player player = null;
        
        while (isRunning){

            while (player == null) {
                 player = new Player();

            }
            while (Run) {
                boolean move = false;

                while (move == false) {
                    //getStatus();
                    System.out.println(ourGame.getCurrentLocation());
                    System.out.println(planet1.get(ourGame.getCurrentLocation()).getDescription());
                    System.out.println(planet1.get(ourGame.getCurrentLocation()).getDirections());
                    System.out.println(planet1.get(ourGame.getCurrentLocation()).getItems());
                    String[] action = UserInput.action();// ==> [go,west]
                    //send action to a class to update location/inventory/status etc.
                    if (action[0].equals("go")) {
                        String nextLocation = ourGame.getNextLocation(ourGame.getCurrentLocation(), action[1]);
                        if (nextLocation == null) {
                            break;
                        }
                        ourGame.setCurrentLocation(nextLocation);
                        System.out.println(ourGame.getCurrentLocation());
                        System.out.println(planet1.get(ourGame.getCurrentLocation()).getDescription());
                        System.out.println(planet1.get(ourGame.getCurrentLocation()).getDirections());
                        System.out.println(planet1.get(ourGame.getCurrentLocation()).getItems());
                    } else if (action[0].equals("grab") && action[1].equals(planet1.get(ourGame.getCurrentLocation()).getItems())){
                        player.addItem(planet1.get(ourGame.getCurrentLocation()).getItems());
                        planet1.get(ourGame.getCurrentLocation()).setItems(""); //Removes item from location. Empty string for now
                        System.out.println(ourGame.getCurrentLocation());
                        System.out.println(planet1.get(ourGame.getCurrentLocation()).getDescription());
                        System.out.println(planet1.get(ourGame.getCurrentLocation()).getDirections());
                        System.out.println(planet1.get(ourGame.getCurrentLocation()).getItems());

                    }
                    move = true;
                }

            }
        }
    }
}
