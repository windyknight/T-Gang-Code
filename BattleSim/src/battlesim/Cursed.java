/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesim;

import java.text.DecimalFormat;

/**
 *
 * @author Jay Lopez
 */
public class Cursed extends Warrior {
    private final int skepticSpecial = 6;
    private int skepticCount = 0;
    DecimalFormat a = new DecimalFormat("0");
    DecimalFormat b = new DecimalFormat("0.00");
    
    Cursed(String name, Type type, int baseTough, int incTough, int baseDex, int incDex, int baseSmart, int incSmart, double baseArmor, double minDamage, double maxDamage, double baseAttackTime) {
        super(name, type, baseTough, incTough, baseDex, incDex, baseSmart, incSmart, baseArmor, minDamage, maxDamage, baseAttackTime);
    }
    
    public void attack(Skeptic target) {
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
        if (skepticCount >= skepticSpecial) {
            skepticCount = -1;
        }
        else {
            target.takeDamage(range);
        }
        skepticCount++;
        System.out.println(type + " " + name + " attacks for " + a.format(range) + " damage!"); 
    }
    
    public void reset() {
        fullHeal();
        timeBack();
        skepticCount = 0;
    }
    
    public String toString() {
        return type + " " + "Cursed" + " " + name + ": " + maxHp + "HP, " + tough + "TOU, " + dex + "DEX, " + smart + "SMR, " + b.format(trueArmor) + "ARM, " + baseAttackTime + "SPD";
    }
}
