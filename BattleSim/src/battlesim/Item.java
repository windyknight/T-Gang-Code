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
public class Item {
    private String name;
    private int tough;
    private int dex;
    private int smart;
    private double armor;
    private double hp;
    private double regen;
    private double energy;
    private double ias;
    
    Item(String name, int tough, int dex, int smart, double armor, double hp, double regen, double energy, double ias) {
        this.name = name;
        this.tough = tough;
        this.dex = dex;
        this.smart = smart;
        this.armor = armor;
        this.hp = hp;
        this.regen = regen;
        this.energy = energy;
        this.ias = ias;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTough() {
        return tough;
    }
    
    public int getDex() {
        return dex;
    }
    
    public int getSmart() {
        return smart;
    }
    
    public double getArmor() {
        return armor;
    }
    
    public double getHp() {
        return hp;
    }
    
    public double getRegen() {
        return regen;
    }
    
    public double getEnergy() {
        return energy;
    }
    
    public double getIas() {
        return ias;
    }
}
