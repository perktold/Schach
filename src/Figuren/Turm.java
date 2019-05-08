package Figuren;

import Main.Koordinaten;
import Main.SpielFeld;

public class Turm  extends Figur{
    public Turm(boolean farbeweiß){
       if(farbeweiß) {
           this.symbol = 't';
       } else {
           this.symbol = 'T';
       }
    }
    public boolean zugMöglich(SpielFeld spielFeld, Koordinaten von, Koordinaten nach) {
        int deltaX, deltaY;

        deltaX = (von.getX() - nach.getX());
        deltaY = (von.getY() - nach.getY());

        if(deltaX != 0 || deltaY != 0) return false;

        return true;
    }
}
