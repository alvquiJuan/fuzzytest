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
        this.tamano = 40.0;
    }

    public Egg(double tamano) {
        this.tamano = tamano;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        if (tamano<40.0){   
            tamano=40.0;
        }
        else if (tamano>70.0){
            tamano=70;
        }
        else{
        this.tamano = tamano;
        }
    }
    
    
    
    
    
    
}
