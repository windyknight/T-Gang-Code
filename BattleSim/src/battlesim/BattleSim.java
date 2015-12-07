/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesim;

import java.io.*;

import java.util.*;

/**
 *
 * @author Jay Lopez
 */
public class BattleSim {
    private static Object item;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Warrior> list = new ArrayList<>();
        ArrayList<Item> item = new ArrayList<>();
        
        Warrior p1 = new Warrior("Tigangster", Type.SMART, 18, 1, 20, 2, 25, 3, 1.8, 44, 54, 1.7);
        Cursed p2 = new Cursed("Log'ma-Maw", Type.TOUGH, 23, 2, 22, 2, 16, 2, 4.52, 64, 68, 1.7);
        Warrior p3 = new Warrior("Tigangster", Type.SMART, 18, 1, 20, 2, 25, 3, 1.8, 44, 54, 1.7);
        Mystic p4 = new Mystic("Fermagician", Type.DEXTEROUS, 22, 1, 22, 3, 15, 2, 2.08, 49, 53, 1.7);
        Shredder op = new Shredder("Meta Knight", Type.DEXTEROUS, 50, 6, 50, 5, 50, 5, 20, 80, 85, 3.0);
        
        //System.out.println(op);
        
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(op);
        list.add(new Brute("Dorm Defender", Type.SMART, 20, 1, 25, 2, 30, 3, 5, 50, 60, 3));
        list.add(new Skeptic("Jalvinator", Type.SMART, 15, 1, 30, 2, 50, 3, 3, 20, 60, 3.5));
        list.add(new Cursed("Lord Petri", Type.DEXTEROUS, 5, 1, 50, 3, 100, 5, 2, 50, 100, 5));
        list.add(new Skeptic("Sir Tigang", Type.TOUGH, 80, 2, 50, 2, 30, 2, 8, 10, 40, 6));
        list.add(new Shredder("Satanas", Type.DEXTEROUS, 30, 1, 80, 5, 20, 1, 10, 50, 100, 4));
        
        item.add(new Item("The Unholy Long Test", 0, 3, 15, 0, 50, 20, 0, -10));
        item.add(new Item("Arghs' Golden Hair", 0, 0, 0, 8, 150, 20, 0, 15));
        item.add(new Item("Swipe Card", 5, 5, 5, 0, 100, 10, 10, 30));
        item.add(new Item("The Edge", 40, 20, 0, 20, 50, 0, 0, 0));
        item.add(new Item("Used Nitro Tank of The Turbo Lord", 0, 50, 30, -20, -30, 0, 0, 100));
        item.add(new Item("Heart of Petri", 0, 10, 30, 50, 100, 10, 0, 0));
        item.add(new Item("Project Plan", 30, 20, 0, 0, 0, 30, 10, 50));
        item.add(new Item("Osit's Bell", 0, 0, 50, 0, 0, 50, 0, 0));
        item.add(new Item("Magic Merland XXL", 10, 10, 10, 69, 150, 30, 0, 0));
        item.add(new Item("Bounce Juice", 0, 0, 100, 0, 500, 100, 1000, 500));
        item.add(new Item("Jojo's Confiscated Laptop Cache", 30, 0, 50, 100, 100, 30, 0, 50));
        item.add(new Item("Rosette Stone", 0, 0, 80, 50, 1000, 20, 0, 0));
        
        System.out.println("Select warrior.");
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(i + ". " + list.get(i - 1));
        }
        System.out.print("Choose: ");
        Warrior chosenOne = list.get(Integer.parseInt(bfr.readLine()) - 1);
        
        
        for (int i = 1; i <= 6; i++) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("Equip items");
            System.out.println("Equipped Items: ");
            chosenOne.getItem();
            for (int j = 1; j <= item.size(); j++) {
                System.out.println(j + ". " + item.get(j - 1));
            }
            System.out.print("Choose: ");
            chosenOne.takeItem(item.get(Integer.parseInt(bfr.readLine()) - 1));
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        
        System.out.println("Select warrior.");
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(i + ". " + list.get(i - 1));
        }
        System.out.print("Choose: ");
        Warrior chosenTwo = list.get(Integer.parseInt(bfr.readLine()) - 1);
        
        
        for (int i = 1; i <= 6; i++) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("Equip items");
            System.out.println("Equipped Items: ");
            chosenTwo.getItem();
            for (int j = 1; j <= item.size(); j++) {
                System.out.println(j + ". " + item.get(j - 1));
            }
            System.out.print("Choose: ");
            chosenTwo.takeItem(item.get(Integer.parseInt(bfr.readLine()) - 1));
        }
        
        chosenOne.battle(chosenTwo);
    }
    
}
