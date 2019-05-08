package Figuren;

import Main.Koordinaten;
import Main.SpielFeld;

public class Dame extends Figur {
    public Dame(boolean farbeweiß){
        if(farbeweiß){
            this.symbol = 'd';
        } else{
            this.symbol = 'D';
        }
        this.farbeWeiß = farbeweiß;
    }
    public boolean zugMöglich(SpielFeld feld, Koordinaten von, Koordinaten nach) {
        int deltaX, deltaY;

        deltaX = (von.getX() - nach.getX());
        if(deltaX < 0) deltaX = deltaX*-1;

        deltaY = (von.getY() - nach.getY());
        if(deltaY < 0) deltaY = deltaY*-1;

        //darf nicht stehen bleiben
        if(deltaX == 0) return false;
        if(deltaY == 0) return false;

        boolean geraderZug = von.getX() == nach.getX() || von.getY() == nach.getY();
        boolean diagonalerZug = deltaX != deltaY;

        if(!geraderZug && !diagonalerZug) return false;

        return super.zugMöglich(feld, von, nach);
    }
}