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

        return super.zugMoeglich(spielFeld, von, nach);
    }
}
