package Figuren;

import Main.*;


public class Laeufer extends Figur {
    public Laeufer(boolean farbeWeiss){
        this.farbeWeiss = farbeWeiss;
        if(farbeWeiss){
            this.symbol = 'l';
        } else {
            this.symbol = 'L';
        }
    }

    public boolean zugMöglich(SpielFeld spielFeld, Position von, Position nach) {
        int deltaX, deltaY;

        deltaX = (von.getX() - nach.getX());
        if(deltaX < 0) deltaX = deltaX*-1;

        deltaY = (von.getY() - nach.getY());
        if(deltaY < 0) deltaY = deltaY*-1;

        //darf nicht stehen bleiben
        if(deltaX == 0) return false;
        if(deltaY == 0) return false;

        //muss diagonal laufen
        if(deltaX != deltaY) return false;

        return super.zugMoeglich(spielFeld, von, nach);
    }

}
