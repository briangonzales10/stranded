package com.game.player;

import com.game.items.Item;
import com.game.textparser.UserInput;

import java.util.ArrayList;

public class Player {
    private static String name;
    private static ArrayList<Item> inventory = new ArrayList<Item>();
    //private String currentLocation = "Crash Site";

    public Player(){
        setName();

    }

    //Name Getter and Setter
    public static String getName(){
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
    public static void addItem(Item item){
        inventory.add(item);
    }

    public static StringBuilder viewInventory(){
        StringBuilder inventoryString = new StringBuilder();

        for(Item item: inventory){
            inventoryString.append(item.getItemName()).append(" ");
        }
        return inventoryString;
    }




}
