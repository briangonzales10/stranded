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
}
