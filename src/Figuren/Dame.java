package Figuren;

import Main.Position;
import Main.SpielFeld;

public class Dame extends Figur {
    public Dame(boolean farbeweiss){
        this.farbeWeiss = farbeweiss;
        if(farbeweiss){
            this.symbol = 'd';
        } else{
            this.symbol = 'D';
        }
    }
    public boolean zugMoeglich(SpielFeld feld, Position von, Position nach) {
        int deltaX, deltaY;
        deltaX = Math.abs(nach.getX() - von.getX());
        deltaY = Math.abs(nach.getY() - von.getY());
        
        boolean geraderZug = deltaX == 0 || deltaY == 0;
        boolean diagonalerZug = deltaX == deltaY;

        if(!geraderZug && !diagonalerZug) return false;

        return super.zugMoeglich(feld, von, nach);
    }
}
