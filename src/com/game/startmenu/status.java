package com.game.startmenu;

public class status {

    //private instance fields
    private String action;
    private String noun;


    // Constructor
    public status(String[] command) {
        setAction(command[0]);
        setNoun(command[1]);
    }

    //Methods for actions

    private void action(String[] command) throws IllegalArgumentException{

        if (command[0].equals("go")) {
            //Execute move to change current room to command[1]
        }

        if (command[0].equals("grab")) {
            //execute grab command & add item to player inventory / remove from room inventory
        }

        if (command[0].equals("search")) {
            //Execute Search command and reveal hidden items in room + add to room inventory
        }
        else throw new IllegalArgumentException("not valid commands");

    }
// status.action(userInput)

    //Getters & Setters
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

//    public static String getStatus() {
//        return name + description + commands;
//    }
}
