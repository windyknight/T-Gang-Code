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
public class Shredder extends Warrior {
    private boolean cursedAffliction = false;
    private final int mysticSpecial = 6;
    private int mysticCount = 0;
    private final int skepticSpecial = 5;
    private int skepticCount = 0;
    private final int bruteSpecial = 4;
    private int bruteCount = 0;
    
    Shredder(String name, Type type, int baseTough, int incTough, int baseDex, int incDex, int baseSmart, int incSmart, double baseArmor, double minDamage, double maxDamage, double baseAttackTime) {
        super(name, type, baseTough, incTough, baseDex, incDex, baseSmart, incSmart, baseArmor, minDamage, maxDamage, baseAttackTime);
    }
    
    public void attack(Cursed target) {
        if(!(cursedAffliction)) {
            increaseIas(-20);
            cursedAffliction = true;
        }
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
        System.out.print(type + " " + name + " attacks for " + range + " damage!");
    }
    
    public void attack(Mystic target) {
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
        if (mysticCount >= mysticSpecial) {
            mysticCount = -1;
            target.takeDamage(range, 0);
        }
        else {
            target.takeDamage(range);
        }
        mysticCount++;
        System.out.print(type + " " + name + " attacks for " + range + " damage!\n");
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
        target.takeDamage(range);
        skepticCount++;
        System.out.print(type + " " + name + " attacks for " + range + " damage!\n");
        
        //eff this
    }
}
