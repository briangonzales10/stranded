package com.game.conditions;

import com.game.enemies.Alien;
import com.game.items.Item;
import com.game.player.Player;
import com.game.startmenu.status;
import com.game.textparser.UserInput;

public class Combat {

    //default constructor
    public Combat() throws InterruptedException {
        Alien soldier = createAlien();

        status.clearConsole();
        startCombat(soldier);

        //soldier.Attack();//Might modify to take in Player class
    }

    private Alien createAlien() {
        Alien soldier = new Alien(30, 3, 3, "soldier", "Alien Compound");

        return soldier;
    }

    private void startCombat(Alien soldier) {
        while (soldier.isAlive()) {
            //Verify action

            boolean doAction = false;
            while (!doAction) {

                String[] action = UserInput.action();

                //verify a fight command was used somehow...
                if (action[0].equals("NOT")) {
                    System.out.println("You can't do that right now, you're fighting an alien!");
                }
                doAction = true;
            }

            //Grab me the right weapon or null from inventory

            Item weapon = null;

            //Combat
            Player.attack(soldier, weapon);
            soldier.Attack();
        }
    }
}
