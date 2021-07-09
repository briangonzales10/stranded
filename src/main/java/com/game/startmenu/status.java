package com.game.startmenu;

import com.game.items.Item;
import com.game.player.Player;
import com.game.world.gameWorld;
import com.game.world.location;

import java.util.ArrayList;
import java.util.HashMap;

public class status {

    String action = "None";
    String noun = "";
    String result = "";

    // Constructor
    public status() {

    }

    //Methods for actions

    public void action(String[] command) throws IllegalArgumentException{
    //command[0] is action, command[1] is direction/item/etc.

        //Initialize variables for action logic
        String currentLoc = gameWorld.getCurrentLocation();
        HashMap<String, ArrayList<Item>> inventoryMap = gameWorld.getGameItems();
        ArrayList<Item> inventoryArray = inventoryMap.get(currentLoc);
        HashMap<String, ArrayList<Item>> hiddenItemsMap = gameWorld.getHiddenItems();
        ArrayList<Item> hiddenItemsArray = hiddenItemsMap.get(currentLoc);
        ArrayList<Item> playerItems = Player.getInventory();

        if (currentLoc == null || currentLoc.equals("")) {
            currentLoc = gameWorld.getPreviousLocation();
        }

        if (command[0].equals("go")) {
            //Execute move to change current room to command[1]
           String nextLoc = gameWorld.getNextLocation(currentLoc,command[1]); //checks what location is n/e/s/w of current location
           if (nextLoc == null || nextLoc.equals("")) {
               setResult("You can't go that way");
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
                    setResult(item.getItemName() + " grabbed!");
                } else {
                    count += 1;
                }
            }

            if (count == inventoryArray.size()){
                setResult("Nothing there to grab!");
            } else {
                inventoryArray.remove(removeItem);
            }
        }

        if (command[0].equals("search")) {
            //Execute Search command and reveal hidden items in room + add to room inventory

            for (Item hiddenItem: hiddenItemsArray) {
                if (hiddenItem != null) {
                    setResult(hiddenItem.getItemName() + " uncovered!");
                    inventoryArray.add(hiddenItem);
                }
                else {
                    setResult("No hidden items found.");
                }
            }
        }

        if (command[0].equals("drop")) {
            //user types drop + item name from player inventory

            Item dropItem = null;
            for (Item item : playerItems){
                if (item.getItemName().equals(command[1])) { //If item from player's inventory matches dropped item
                    dropItem = item;
                    //item is added to current location inventory
                    inventoryArray.add(item);
                }
            }
            if (dropItem != null) {
                playerItems.remove(dropItem);
                setResult("You dropped a "+ dropItem.getItemName());
            }

        }

        if (command[0].equals("use")) {
            //Check if command[1] is in player inventory
            Item usedItem = null;
            for (Item item : playerItems){
                if (item.getItemName().equals(command[1])) { //If item from player's inventory matches use item
                    usedItem = item;
                }
            }
            if (usedItem == null) {
                setResult("You don't have " + command[1] +" in your inventory!");
            }

            //check if food item, then setHP
            if (usedItem != null) {

                if (usedItem.getType().equals("food")) {
                    Player.setHP(usedItem.getHpValue());
                    playerItems.remove(usedItem); // remove after using food
                    setResult(command[1] + " used!");
                }
                else if (usedItem.getType().equals("weapon")) {
                //Can update weapon use later with combat system
                    setResult("Pew Pew");
                } else {
                    setResult("No use for that here"); //If not weapon or food type, say "no use here"
                }
            }

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

        System.out.println("===================================================");
        System.out.println("Location: " + currentLocData.getName());
        System.out.println("===================================================");
        System.out.println("Description: " + currentLocData.getDescription());
        System.out.println("\n");
        System.out.println("Items you see: " + gameWorld.getItemsByLocation(currentLoc));
        System.out.println("===================================================");
        System.out.println("Name: " + Player.getName() + " | HP: " + Player.getHP() + " / " + Player.getMaxHp());
        System.out.println("Current Inventory: " + Player.viewInventory());
        System.out.println("---------------------------------------------------");
        System.out.println("Last action taken: " + action + " "+ noun);
        System.out.println(getResult()); //Display action results
        setResult(""); //Reset action results for next action

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



    //private methods
    private String getAction() {
        return action;
    }

    private void setAction(String action) {
        this.action = action;
    }

    private String getResult() {
        return result;
    }

    private void setResult(String result) {
        this.result = ">" + result;
    }

    private String getNoun() {
        return noun;
    }

    private void setNoun(String noun) {
        this.noun = noun;
    }
}
