package com.game.enemies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.game.player.Player;

import java.util.Random;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Alien {

    //Instance Fields
    private int HP;
    private int attackDamage; //Damage strength per enemy 0-10 recommended..
    private int defense; //incoming Attack int divided by this amount
    private String type;
    private String location;
    private boolean isAlive;

    //Constants
    private final int MIN_HP = 0;


    //Jackson default constructor
    public Alien() {
        super();
    }
    //Alien Constructor
    public Alien(int HP, int attackDamage, int defense, String type, String location) {
        setHP(HP);
        setAttackDamage(attackDamage);
        setDefense(defense);
        setType(type);
        setLocation(location);
        setAlive();
    }

    //Fight methods

    public void Attack() {
        // Gives 1/chance # of a super attack.
        // Currently 8.3%
        Random rand = new Random();
        int chance = 12;

        if (getType().equals("boss")) { //Bosses get higher superAttack chance!
            chance = 10;
        }

        int randAttack = rand.nextInt(chance);

        if (randAttack == chance-1) {
            Player.takeDamage(superAttack());
        }
        else {
            Player.takeDamage(normalAttack());
        }
    }

    private int normalAttack() {
        Random rand = new Random();
        int range = rand.nextInt(3)+1;

        int damage = attackDamage * range;
        System.out.println(getType() + " attacks for " + damage);
       return damage;
    }

    private int superAttack() {
        Random rand = new Random();
        int range = rand.nextInt(6)+1;

        int damage = attackDamage * range;
        System.out.println(getType() + " attacks for " + damage);
        return damage;
    }

    public void takeDamage(int AttackStr) {
        int totalDamage = AttackStr/defense;
        System.out.println( getType()+" took " + totalDamage + " damage!");
        setHP(-totalDamage);
    }

    //Getters & Setters
    public int getHP() {
        return HP;
    }

    private void setHP(int HP) {
        // If HP value is negative and takes HP below 0, just set to MIN_HP
        if (HP <= MIN_HP) {
            this.HP = MIN_HP;
            setAlive(); //Will change alive to false if at or below min
        }
        this.HP += HP;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive() {
        if (HP > MIN_HP) {
            this.isAlive = true;
        } else {
            this.isAlive = false;
        }
    }
}