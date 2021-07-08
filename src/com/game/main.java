package com.game;

import com.game.conditions.Win;
import com.game.player.Player;
import com.game.startmenu.StartMenu;
import com.game.startmenu.status;
import com.game.textparser.UserInput;
import com.game.world.gameWorld;
import com.game.world.location;

import java.io.IOException;
import java.util.HashMap;

public class main {
    public static void main(String[] args) throws InterruptedException, IOException {
        boolean isRunning = true;
        StartMenu start = new StartMenu();
        gameWorld ourGame = new gameWorld();
        status status = new status();

        HashMap<String, location> planet1 = ourGame.getPlanet1();

        boolean Run = true;
        Player player = null;
        
        while (isRunning){

            while (player == null) {
                 player = new Player();

            }
           while (Run) {
                boolean move = false;

                while (!move) {

                    if (gameWorld.getCurrentLocation() != null){

                        if(Player.keyItemCheck() == 2 && gameWorld.getCurrentLocation().equals("Crash Site")){
                            gameWorld.setCurrentLocation("Landing Site");
                        }

                        if (Player.keyItemCheck() == 3 && gameWorld.getCurrentLocation().equals("Landing Site")) {
                            Win.youWin();
                            Run = false;
                            isRunning = false;
                            break;
                        }
                    }


                    status.display();
                    String[] action = UserInput.action();// ==> [go,west]
                    //send action to a class to update location/inventory/status etc.
                    status.action(action);
                    move = true;
                    }

                }

            }
        }
    }

