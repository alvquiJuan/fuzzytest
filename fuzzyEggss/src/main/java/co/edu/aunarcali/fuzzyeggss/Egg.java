/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.aunarcali.fuzzyeggss;

/**
 *
 * @author Juan Manuel Alvarez
 */
public class Egg {
    private double tamano;

    public Egg() {
        new Egg(50);
    }

    public Egg(double tamano) {
        this.tamano = tamano;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        if (tamano<50.0){   
            tamano=50;
        }
        else if (tamano>70.0){
            tamano=70;
        }
        else{
        this.tamano = tamano;
        }
    }
    
    
    
    
    
    
}
