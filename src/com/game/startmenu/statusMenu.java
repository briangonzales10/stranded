package com.game.startmenu;

public class statusMenu {
    private String name;
    private String description;
    private String commands;
    private String directions;


    public statusMenu(String name, String description, String commands, String directions) {
        this.name = name;
        this.description = description;
        this.commands = commands;
        this.directions = directions;
    }
    public statusMenu(String[] action) {
        if (action[0] == "go") {

        }
    }

//    public static String getStatus() {
//        return name + description + commands;
//    }
}
