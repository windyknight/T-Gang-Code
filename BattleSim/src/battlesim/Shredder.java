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
    Shredder(String name, Type type, int baseTough, int incTough, int baseDex, int incDex, int baseSmart, int incSmart, double baseArmor, double minDamage, double maxDamage, double baseAttackTime) {
        super(name, type, baseTough, incTough, baseDex, incDex, baseSmart, incSmart, baseArmor, minDamage, maxDamage, baseAttackTime);
    }
}
