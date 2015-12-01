/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesim;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Jay Lopez
 */
public class BattleSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        
        int choice = 0;
        
        Warrior p1 = new Warrior("Void Seeder", Type.SMART, 18, 1, 20, 2, 25, 3, 1.8, 44, 54, 1.7);
        Cursed p2 = new Cursed("Cerebus Knight", Type.TOUGH, 23, 2, 18, 2, 16, 2, 4.52, 64, 68, 1.7);
        Warrior p3 = new Warrior("Void Seeder", Type.SMART, 18, 1, 20, 2, 25, 3, 1.8, 44, 54, 1.7);
        Mystic p4 = new Mystic("Infinitum", Type.DEXTEROUS, 22, 1, 22, 3, 15, 2, 2.08, 49, 53, 1.45);
        
        p2.battle(p4);
    }
    
}
