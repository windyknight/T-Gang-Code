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
public enum Type {
    SMART ("Smart"),
    TOUGH ("Tough"),
    DEXTEROUS ("Dexterous");
    
    private final String name;
    
    Type(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
