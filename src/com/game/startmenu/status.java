package com.game.startmenu;

import com.game.player.Player;
import com.game.textparser.UserInput;
import com.game.world.gameWorld;
import com.game.world.location;

public class status {

    String action = "None";
    String noun = "";

    // Constructor
    public status() {

    }

    //Methods for actions

    public void action(String[] command) throws IllegalArgumentException{
    //command[0] is action, command[1] is direction/item/etc.
        String currentLoc = gameWorld.getCurrentLocation();
        location currentLocData = gameWorld.getPlanet1().get(currentLoc);

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

            if (!command[1].equals(currentLocData.getItems())) {
                System.out.println("Nothing there to grab!");
                //UserInput.action();
            } else {
                Player.addItem(command[1]);
                System.out.println(command[1] + " grabbed!");
                gameWorld.getPlanet1().get(currentLoc).setItems(""); //removes item from loc inventory
            }
        }

        if (command[0].equals("search")) {
            //Execute Search command and reveal hidden items in room + add to room inventory
            //Temporary fix for grabbing hidden items until we change item to an array list
            String hiddenItem = gameWorld.getPlanet1().get(currentLoc).getHiddenItems();
            if (currentLocData.getItems() == null || currentLocData.getItems().equals("")) {
                currentLocData.setItems(currentLocData.getHiddenItems()); // sets Location item to hidden item
            } else {
                System.out.println("There's a hidden item but the " + currentLocData.getItems() +" is in the way");
            }
        }

        if (command[0].equals("drop")) {
            //drop code here
        }
        //else throw new IllegalArgumentException("not valid commands");

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
        System.out.println("Items you see: " + currentLocData.getItems());
        System.out.println("=========================================");
        System.out.println("Name: " + Player.getName() + " | Current Inventory:" + Player.viewInventory());
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

        Thread.sleep(2000);

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
