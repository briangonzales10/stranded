package com.game.player;

import com.game.items.Item;
import com.game.textparser.UserInput;
import com.game.world.gameWorld;

import java.util.ArrayList;

public class Player {

    //Static Fields for player
    private static String name;
    private static int HP;
    private static ArrayList<Item> inventory = new ArrayList<Item>();
    private static int movePenalty = -10;

    //Constant Fields
    private static final int MAX_HP = 100;
    private static final int MIN_HP = 0;

    //Player Constructor
    public Player(){
        setName();
        //setHP(MAX_HP);
        setHP(85); //for testing
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

    public static void eat(Item foodItem) {
        //add HP value from food type item and remove from inventory
        setHP(foodItem.getHpValue());
        inventory.remove(foodItem);
    }

    // Player manipulation methods
    public static void move(String nextLoc) {
        //reduces HP for player movement & updates location
        setMovePenalty();  //readjust move penalty before moving

        setHP(getMovePenalty());
        gameWorld.setCurrentLocation(nextLoc);
    }

    //Getters & Setters
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

    //Private getters & setters
    private static int getMovePenalty() {
        return movePenalty;
    }

    private static void setMovePenalty() {
        //Set based on current player HP
        if (getHP() < 50 ) {
            movePenalty = -5;
        }
        else {
            movePenalty = -10;
        }
    }






}
