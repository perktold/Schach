package Figuren;

import Main.Position;
import Main.SpielFeld;

public class Turm  extends Figur{
    public Turm(boolean farbeweiss){
        this.farbeWeiss = farbeweiss;
        if(farbeweiss) {
            this.symbol = 't';
        } else {
            this.symbol = 'T';
        }
    }
    
    public boolean zugMoeglich(SpielFeld spielFeld, Position von, Position nach) {
    	 int deltaX, deltaY;
    	 deltaX = Math.abs(nach.getX() - von.getX());
         deltaY = Math.abs(nach.getY() - von.getY());
         
         if(deltaX != 0 && deltaY != 0) return false;
        return super.zugMoeglich(spielFeld, von, nach);
    }
}
