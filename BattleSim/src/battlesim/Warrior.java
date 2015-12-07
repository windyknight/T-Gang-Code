/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesim;

import java.util.*;
import java.text.DecimalFormat;
/**
 *
 * @author Jay Lopez
 */
public class Warrior {
    protected String name;
    protected Type type;
    protected int level;
    //protected base stats//
    protected final double baseHp = 150;
    protected final double baseEnergy = 0;
    protected int baseTough; //hp and regen
    protected int baseDex; //armor and ias
    protected int baseSmart; //energy
    protected int incTough;
    protected int incDex;
    protected int incSmart;
    protected final double baseRegen = 0.25;
    protected double baseAttackTime;
    protected double baseArmor;
    //end protected base stats//
    protected double minDamage;
    protected double maxDamage;
    protected double currentHp;
    protected double maxHp;
    protected double energy;
    protected double trueArmor;
    protected double incAttackSpd;
    protected ArrayList<Item> items;
    //final stats to be used in combat//
    protected int tough; //hp and regen
    protected int dex; //armor and ias
    protected int smart; //energy
    protected double regen;
    protected double damageMitigation;
    protected double attackCooldown;
    protected boolean alive;
    protected double time;
    protected double followUp;
    DecimalFormat a = new DecimalFormat("0");
    DecimalFormat b = new DecimalFormat("0.00");
    
    Warrior(String name, Type type, int baseTough, int incTough, int baseDex, int incDex, int baseSmart, int incSmart, double baseArmor, double minDamage, double maxDamage, double baseAttackTime) {
        this.name = name;
        this.type = type;
        this.baseTough = baseTough;
        this.incTough = incTough;
        this.baseDex = baseDex;
        this.incDex = incDex;
        this.baseSmart = baseSmart;
        this.incSmart = incSmart;
        this.baseArmor = baseArmor;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.baseAttackTime = baseAttackTime;
        this.items = new ArrayList<>();
        this.alive = true;
        this.time = 0;
        this.level = 1;
        computeNewStats();
    }
    
    
    public void computeNewStats() {
        tough = baseTough + ((level - 1) * incTough);
        for (Item a : items) {
            tough += a.getTough();
        }
        
        smart = baseSmart + ((level - 1) * incSmart);
        for (Item a : items) {
            smart += a.getSmart();
        }
        
        dex = baseDex + ((level - 1) * incDex);
        for (Item a : items) {
            dex += a.getDex();
        }
        
        regen = baseRegen + (tough * 0.03);
        for (Item a : items) {
            regen += a.getRegen();
        }
        
        maxHp = baseHp + (tough * 19);
        for (Item a : items) {
            maxHp += a.getHp();
        }
        
        energy = baseEnergy + (smart * 13);
        for (Item a : items) {
            energy += a.getEnergy();
        }
        
        trueArmor = baseArmor + (0.14 * dex);
        for (Item a : items)  {
            trueArmor += a.getArmor();
        }
        
        incAttackSpd = dex;
        for (Item a : items) {
            incAttackSpd += a.getIas();
        }
        computeMitigation();
        computeCooldown();
    }
    
    public void computeMitigation() {
        damageMitigation = (0.06 * trueArmor) / (1 + (0.06 * trueArmor));
    }
    
    public void computeCooldown() {
        attackCooldown = ((int)(baseAttackTime / (1 + (incAttackSpd / 100)) * 100)) / 100.00;
    }
    
    public void setCooldown(double cool) {
        this.attackCooldown = cool;
    }
    
    public double getCooldown(){
        return attackCooldown;
    }
    
    public void levelUp() {
        level += 1;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void fullHeal() {
        currentHp = maxHp;
        alive = true;
    }
    
    public void partialHeal(double heal) {
        currentHp = currentHp + heal > maxHp ? maxHp : currentHp + heal;
    }
    
    public void takeItem (Item item) {
        items.add(item);
        computeNewStats();
    }
    
    public void dropItem (Item item) {
        if (items.indexOf(item) > -1) {
            items.remove(item);
            computeNewStats();
        }
    }
    
    public void getItem() {
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i).namer() + " ");
            System.out.println();
        }
    }
    
    public void takeDamage(double damage) {
        damage *= 1 - damageMitigation;
        currentHp -= damage;
        if (currentHp <= 0) {
            alive = false;
        }
    }
    
    public void attack (Warrior target) {
        if (this instanceof Mystic) {
            if (target instanceof Cursed)
            {((Mystic)this).attack((Cursed)target); return;}
            else if (target instanceof Brute)
            {((Mystic)this).attack((Brute)target); return;}
            
        }
        else if (this instanceof Cursed) {
            if (target instanceof Skeptic)
            {((Cursed)this).attack((Skeptic)target); return;}
            
        }
        else if (this instanceof Brute) {
            if (target instanceof Cursed)
            {((Brute)this).attack((Cursed)target); return;}
            
        }
        else if (this instanceof Skeptic) {
            if (target instanceof Mystic)
            {((Skeptic)this).attack((Mystic)target); return;}
            else if (target instanceof Brute)
            {((Skeptic)this).attack((Brute)target); return;}
            
        }
        else if (this instanceof Shredder) {
            if (target instanceof Skeptic) //annoying code here
            {((Shredder)this).attack((Skeptic)target); return;}
            else if (target instanceof Cursed)
            {((Shredder)this).attack((Cursed)target); return;}
            else if (target instanceof Mystic)
            {((Shredder)this).attack((Mystic)target); return;}
            else if (target instanceof Brute)
            {((Shredder)this).attack((Brute)target); return;}
            
        }
        //defalt code
        double range = maxDamage - minDamage;
        range += Math.random() * range + minDamage;
        if (type == Type.TOUGH) {
            range += tough;
        }
        if (type == Type.DEXTEROUS) {
            range += dex;
        }
        if (type == Type.SMART) {
            range += smart;
        }
        target.takeDamage(range);
        System.out.println(type + " " + name + " attacks for " + a.format(range) + " damage!");  
        
    }
    
    @Override
    public String toString() {
        return type + " " + name + ": " + maxHp + "HP, " + tough + "TOU, " + dex + "DEX, " + smart + "SMR, " + b.format(trueArmor) + "ARM, " + baseAttackTime + "SPD";
    }
    
    public double getCurrentHp() {
        return currentHp;
    }
    
    public double getMaxHp() {
        return maxHp;
    }
    
    public double getIas() {
        return incAttackSpd;
    }
    
    public void increaseIas(double value) {
        incAttackSpd += value;
        computeCooldown();
    }
    
    public double getEnergy() {
        return energy;
    }
    
    public boolean isAlive() {
        return alive;
    }
    
    public void regenerate() {
        partialHeal(regen);
    }
    
    public void battle(Warrior enemy) {
        this.reset();
        enemy.reset();
        System.out.println(this + " versus " + enemy);
        while (true) {
            if((int)(time * 100) % (int)(getCooldown() * 100) == 0) {
                System.out.print("[" + b.format(time) + "] ");
                attack(enemy);
                System.out.println(this.status());
                System.out.println(enemy.status());
                if (!enemy.isAlive())
                    break;
            }
            if((int)(time * 100) % (int)(enemy.getCooldown() * 100) == 0) {
                System.out.print("[" + b.format(time) + "] ");
                enemy.attack(this);
                System.out.println(this.status());
                System.out.println(enemy.status());
                if (!this.isAlive())
                    break;
            }
            if((int)(time * 100) % 100 == 0) {
                this.regenerate();
                enemy.regenerate();
                System.out.println("[" + b.format(time) + "] " + "Regeneration.");
                System.out.println(this.status());
                System.out.println(enemy.status());
            }
            time += 0.01;
        }
        if (this.isAlive()) {
            System.out.println("Combatant 1 wins!");
        }
        else if (enemy.isAlive()) {
            System.out.println("Combatant 2 wins!");
        }
    }

    public void reset() {
        fullHeal();
        timeBack();
    }
    
    public void timeBack() {
        time = 0;
        followUp = 0;
    }
    
    public double getTime() {
        return time;
    }
    
    public void setFollowUp(double followUp) {
        this.followUp = followUp;
    }
    
    public void repeatAttack(Warrior target) {
        if ((int)(this.time * 100) == (int)(this.followUp * 100)) {
            this.attack(target);
        }
    }
    
    public String status() {
        return name + ": " + a.format(currentHp) + " / " + a.format(maxHp);
    }
    
    public void clearOut() {
        items.clear();
    }
}
