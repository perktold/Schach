package Figuren;

import Main.Koordinaten;
import Main.SpielFeld;

public class Springer extends Figur {
    public Springer(boolean farbeWeiß){
        this.farbeWeiß = farbeWeiß;
        if(farbeWeiß){
            this.symbol = 's';
        } else {
            this.symbol = 'S';
        }
    }
    public boolean zugMöglich(SpielFeld spielFeld, Koordinaten von, Koordinaten nach) {

        return super.zugMöglich(spielFeld, von, nach);
    }
}
