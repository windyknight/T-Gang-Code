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
public class Brute extends Warrior {
    Brute(String name, Type type, int baseTough, int incTough, int baseDex, int incDex, int baseSmart, int incSmart, double baseArmor, double minDamage, double maxDamage, double baseAttackTime) {
        super(name, type, baseTough, incTough, baseDex, incDex, baseSmart, incSmart, baseArmor, minDamage, maxDamage, baseAttackTime);
    }

    public void takeDamage(double range, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
