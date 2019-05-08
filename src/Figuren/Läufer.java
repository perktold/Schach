package Figuren;

import Main.*;


public class Läufer extends Figur {
    public Läufer(boolean farbeWeiß){
        if(farbeWeiß){
            this.symbol = 'l';
        } else {
            this.symbol = 'L';
        }
        this.farbeWeiß = farbeWeiß;
    }

    public boolean zugMöglich(SpielFeld spielFeld, Koordinaten von, Koordinaten nach) {
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

        return super.zugMöglich(spielFeld, von, nach);
    }

}
