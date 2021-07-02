package com.game.player;

import com.game.textparser.UserInput;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<String> inventory = new ArrayList<>();
    //private String currentLocation = "Crash Site";

    public Player(){
        setName();

    }

    //Name Getter and Setter
    public String getName(){
        return name;
    }

    public void setName(){
        name = UserInput.setPlayerName();
        System.out.println("Welcome aboard Commander " + name + "!");
    }

    //Location
   /* public String getCurrentLocation(){
        return currentLocation;
    }

    */

    public void setCurrentLocation(){
        //Need to add logic to set Location
    }



    //Inventory method will go below
    public void addItem(String item){
        inventory.add(item);
    }

    public StringBuilder viewInventory(){
        StringBuilder inventoryString = new StringBuilder();

        for(String item: inventory){
            inventoryString.append(item).append(" ");
        }
        return inventoryString;
    }




}
