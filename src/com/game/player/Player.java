package com.game.player;

import com.game.items.Item;
import com.game.textparser.UserInput;

import java.util.ArrayList;

public class Player {
    private static String name;
    private static int HP;
    private static final int MAX_HP = 100;
    private static final int MIN_HP = 0;

    private static ArrayList<Item> inventory = new ArrayList<Item>();


    public Player(){
        setName();
        //setHP(MAX_HP);
        setHP(85); //for testing
    }

    //Name Getter and Setter
    public static String getName(){
        return name;
    }

    public void setName(){
        name = UserInput.setPlayerName();
        System.out.println("Welcome aboard Commander " + name + "!");
    }

    public static int getHP() {
        return HP;
    }
    // HP Getters & Setters
    public static void setHP(int HP) {
        // If HP value is negative and takes HP below 0, just set to MIN_HP
        if (Player.HP + HP < MIN_HP) {
            Player.HP = MIN_HP;
        }
        // If HP value is positive and takes HP above 100, set to MAX_HP
        else if (Player.HP + HP > MAX_HP){
            Player.HP = MAX_HP;
        } else {
        // Else just add/subtract to Player HP.
            Player.HP += HP;
        }

    }

    public static int getMaxHp() {
        return MAX_HP;
    }

    public static int getMinHp() {
        return MIN_HP;
    }

    //Inventory methods will go below
    public static void addItem(Item item){
        inventory.add(item);
    }

    public static ArrayList<Item> getInventory() {
        return inventory;
    }

    public static StringBuilder viewInventory(){
        StringBuilder inventoryString = new StringBuilder();

        for(Item item: inventory){
            inventoryString.append(item.getItemName()).append(" ");
        }
        return inventoryString;
    }

    public static int keyItemCheck(){
        int keyItemsInInventory = 0;
        for(Item item: inventory){
            if(item.isKeyItem() == true){
                keyItemsInInventory += 1;
            }
        }
        return keyItemsInInventory;
    }






}
