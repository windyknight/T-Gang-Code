/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesim;

/**
 *
 * @author Jay Lopez
 */
public class Mystic extends Warrior {
    private final int cursedSpecial = 4;
    private final int bruteSpecial = 5;
    private int cursedCount = 0;
    private int bruteCount = 0;
    
    Mystic(String name, Type type, int baseTough, int incTough, int baseDex, int incDex, int baseSmart, int incSmart, double baseArmor, double minDamage, double maxDamage, double baseAttackTime) {
        super(name, type, baseTough, incTough, baseDex, incDex, baseSmart, incSmart, baseArmor, minDamage, maxDamage, baseAttackTime);
    }
    
    public void attack(Cursed target) {
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
        if (cursedCount >= cursedSpecial) {
            cursedCount = -1;
            range += 0.05 * energy;
        }
        target.takeDamage(range);
        cursedCount++;
        System.out.print(type + " " + name + " attacks for " + range + " damage! (override)\n");
    }
    
    public void attack(Brute target) {
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
        if (bruteCount >= bruteSpecial) {
            bruteCount = -1;
            partialHeal(range);
        }
        target.takeDamage(range);
        bruteCount++;
        System.out.print(type + " " + name + " attacks for " + range + " damage!\n");
    }
    
    public void takeDamage(double range, double armorBoost) {
        double first = trueArmor;
        trueArmor *= armorBoost;
        computeMitigation();
        takeDamage(range);
        trueArmor = first;
        computeMitigation();
    }
}
