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

//    public static String getStatus() {
//        return name + description + commands;
//    }
}
