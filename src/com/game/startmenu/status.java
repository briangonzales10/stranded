package com.game.startmenu;

import com.game.items.Item;
import com.game.player.Player;
import com.game.textparser.UserInput;
import com.game.world.gameWorld;
import com.game.world.location;

import java.util.ArrayList;
import java.util.HashMap;

public class status {

    String action = "None";
    String noun = "";

    // Constructor
    public status() {

    }

    //Methods for actions

    public void action(String[] command) throws IllegalArgumentException{
    //command[0] is action, command[1] is direction/item/etc.

        //Initialize variables for action logic
        String currentLoc = gameWorld.getCurrentLocation();
        location currentLocData = gameWorld.getPlanet1().get(currentLoc);
        HashMap<String, ArrayList<Item>> inventoryMap = gameWorld.getGameItems();
        ArrayList<Item> inventoryArray = inventoryMap.get(currentLoc);
        HashMap<String, ArrayList<Item>> hiddenItemsMap = gameWorld.getHiddenItems();
        ArrayList<Item> hiddenItemsArray = hiddenItemsMap.get(currentLoc);

        if (currentLoc == null || currentLoc.equals("")) {
            currentLoc = gameWorld.getPreviousLocation();
        }

        if (command[0].equals("go")) {
            //Execute move to change current room to command[1]
           String nextLoc = gameWorld.getNextLocation(currentLoc,command[1]); //checks what location is n/e/s/w of current location
           if (nextLoc == null || nextLoc.equals("")) {
               System.out.println("You can't go that way");
               //UserInput.action();
           }
            gameWorld.setCurrentLocation(nextLoc); // Updates current location for player
        }

        if (command[0].equals("grab")) {
            //execute grab command & add item to player inventory / remove from room inventory


            int count = 0;
            Item removeItem = null;
            for(Item item: inventoryArray){
                if(item.getItemName().equals(command[1])){
                    Player.addItem(item);
                    removeItem = item;
                    System.out.println(item.getItemName() + " grabbed!");
                } else {
                    count += 1;
                }
            }

            if (count == inventoryArray.size()){
                System.out.println("Nothing there to grab!");
            } else {
                inventoryArray.remove(removeItem);
            }


        }

        if (command[0].equals("search")) {
            //Execute Search command and reveal hidden items in room + add to room inventory

            for (Item hiddenItem: hiddenItemsArray) {
                if (hiddenItem != null) {
                    System.out.println(hiddenItem.getItemName() + " uncovered!");
                    inventoryArray.add(hiddenItem);
                }
                else {
                    System.out.println("No hidden items found.");
                }
            }


        }

        if (command[0].equals("drop")) {
            //user types drop + item name from player inventory
            ArrayList<Item> playerItems = Player.getInventory();
            Item dropItem = null;
            for (Item item : playerItems){
                if (item.getItemName().equals(command[1])) { //If item from player's inventory matches dropped item
                    dropItem = item;
                    //item is added to current location inventory
                    inventoryArray.add(item);
                }
            }
            playerItems.remove(dropItem);


        }


        //Set commands for last action taken by user
        setAction(command[0]);
        setNoun(command[1]);
    }

    public void display() throws InterruptedException{
        clearConsole();
        String currentLoc = gameWorld.getCurrentLocation();
        if (currentLoc == null || currentLoc.equals("")) {
            currentLoc = gameWorld.getPreviousLocation();
        }
        location currentLocData = gameWorld.getPlanet1().get(currentLoc);

        System.out.println("=========================================");
        System.out.println("Location: " + currentLocData.getName());
        System.out.println("=========================================");
        System.out.println("Description: " + currentLocData.getDescription());
        System.out.println("\n");
        System.out.println("Items you see: " + gameWorld.getItemsByLocation(currentLoc));
        System.out.println("=========================================");
        System.out.println("Name: " + Player.getName() + " | Current Inventory: " + Player.viewInventory());
        System.out.println("-----------------------------------------");
        System.out.println("Last action taken: " + action + " "+ noun);

    }

    public static void clearConsole() throws InterruptedException {
        /* Code Attributed to DelftStack
            December 10, 2020
            Use ProcessBuilder to Clear Console in Java
            Example code
            https://www.delftstack.com/howto/java/java-clear-console/
         */

        Thread.sleep(1000);

        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private String getAction() {
        return action;
    }

    private void setAction(String action) {
        this.action = action;
    }

    private String getNoun() {
        return noun;
    }

    private void setNoun(String noun) {
        this.noun = noun;
    }
}
