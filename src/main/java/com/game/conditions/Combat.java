package com.game.conditions;

import com.game.enemies.Alien;
import com.game.items.Item;
import com.game.player.Player;
import com.game.startmenu.status;
import com.game.textparser.UserInput;


public class Combat {

    private static String result = "";
    private static String enemyResult = "";

    private String verb = "None";
    private String noun = "";


    //default constructor
    public Combat() throws InterruptedException {
        Alien soldier = createAlien();

        status.clearConsole();
        startCombat(soldier);

        //soldier.Attack();//Might modify to take in Player class
    }

    //Combat methods
    private Alien createAlien() {
        Alien soldier = new Alien(20, 3, 2, "Alien soldier", "Alien Compound");

        return soldier;
    }

    private void startCombat(Alien soldier) throws InterruptedException {

        while (soldier.isAlive() && (Player.getHP() > Player.getMinHp())) {
            //Verify action

            boolean doAction = false;
            while (!doAction) {

                fightStatus(soldier);
                String[] action = UserInput.action();

                //verify a fight command was used somehow...
                if (action[0].equals("use") || action[0].equals("shoot")) {

                    //Grab me the right weapon or null from inventory
                    Item weapon = null;
                    for (Item item:Player.getInventory()) {
                        if (item.getType().equals("weapon") && item.getItemName().equals(action[1])) {
                            weapon = item;
                        } else {
                            Combat.setResult("That's not a weapon in your inventory!");
                        }
                    }


                    //Combat
                    Player.attack(soldier, weapon);
                    soldier.Attack();
                    soldier.setAlive();
                    if (!soldier.isAlive()){
                        winCombat();
                    }

                    //Results
                    setVerb(action[0]);
                    setNoun(action[1]);
                    doAction = true;
                } else {
                    Combat.setResult("You can't do that right now, you're in combat!");
                }

            }


        }
    }


    private void fightStatus(Alien soldier) throws InterruptedException {
        status.clearConsole();

        System.out.println("**********ALERT, ALIEN IS ATTACKING YOU*************");
        System.out.println("===================================================");
        System.out.println("Enemy: " + soldier.getType() + " HP: " + soldier.getHP());
        System.out.println("===================================================");
        System.out.println("Name: " + Player.getName() + " | HP: " + Player.getHP() + " / " + Player.getMaxHp());
        System.out.println("Weapons available: " + Player.viewInventory("weapon"));
        System.out.println("---------------------------------------------------");
        System.out.println("Last action taken: " + getVerb() + " "+ getNoun());
        System.out.println(">" + getResult());
        System.out.println(">" + getEnemyResult());
        Combat.setResult("");
        Combat.setEnemyResult("");

    }

    private void winCombat() throws InterruptedException{
        status.clearConsole();

        System.out.println("        _..._" +
                "      .'     '.      _\n" +
                "     /    .-\"\"-\\   _/ \\\n" +
                "   .-|   /:.   |  |   |\n" +
                "   |  \\  |:.   /.-'-./\n" +
                "   | .-'-;:__.'    =/\n" +
                "   .'=  *=|    _.='\n"+
                "  /   _.  |    ;\n"+
                " ;-.-'|    \\   |\n"+
                "/   | \\    _\\  _\\\n"+
                "\\__/'._;.  ==' ==\\\n"+
                "         \\    \\   |\n"+
                "         /    /   /\n"+
                "         /-._/-._/\n"+
                "         \\   `\\  \\\n"+
                "          `-._/._/\n" +
                "COMBAT CLEARED"
        );
        Thread.sleep(2000);
        status.clearConsole();
    }

    //Getters & Setters

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }
    public static void setResult(String results) {
        Combat.result = results;
    }

    public String getResult() {
        return result;
    }

    public static String getEnemyResult() {
        return enemyResult;
    }

    public static void setEnemyResult(String enemyResult) {
        Combat.enemyResult = enemyResult;
    }
}
