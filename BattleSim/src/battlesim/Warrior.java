/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesim;

import java.util.*;

/**
 *
 * @author Jay Lopez
 */
public class Warrior {
    private String name;
    private Type type;
    private int level;
    //private base stats//
    private final double baseHp = 150;
    private final double baseEnergy = 0;
    private int baseTough;
    private int baseDex;
    private int baseSmart;
    private int incTough;
    private int incDex;
    private int incSmart;
    private final double baseRegen = 0.25;
    private double baseAttackTime;
    //end private base stats//
    private double minDamage;
    private double maxDamage;
    private double currentHp;
    private double maxHp;
    private double energy;
    private double armor;
    private double incAttackSpd;
    private ArrayList<Item> items;
    //final stats to be used in combat//
    private int tough;
    private int dex;
    private int smart;
    private double regen;
    private double damageMitigation;
    private double attackCooldown;
}
