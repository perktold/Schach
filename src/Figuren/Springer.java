package Figuren;

import Main.Position;
import Main.SpielFeld;

public class Springer extends Figur {
    public Springer(boolean farbeWeiss){
        this.farbeWeiss = farbeWeiss;
        if(farbeWeiss){
            this.symbol = 's';
        } else {
            this.symbol = 'S';
        }
    }
    public boolean zugMoeglich(SpielFeld spielFeld, Position von, Position nach) {
        int deltaX, deltaY;

        deltaX = Math.abs(nach.getX() - von.getX());
        deltaY = Math.abs(nach.getY() - von.getY());

        if(!((deltaX == 2 && deltaY == 1) ||
             (deltaY == 2 && deltaX == 1))){
            return false;
        }

        return super.zugMoeglich(spielFeld, von, nach);
    }
}
