package Figuren;

import Main.*;

public class Bauer extends Figur {
    public Bauer(boolean farbeWeiß){
        if(farbeWeiß){
            this.symbol = 'b';
        } else {
            this.symbol = 'B';
        }
        this.farbeWeiß = farbeWeiß;
    }

    //ganz viel TODO: finish dis
    public boolean zugMöglich(SpielFeld spielFeld, Koordinaten von, Koordinaten nach) {


        if(farbeWeiß){


            //ein bauer darf nicht nach hinten oder nur auf die seite gehen
            if(von.getY() >= nach.getY()) return false;

            //ein bauer darf nur zwei nach vorne, wenn er auf zeile 7 steht
            if(nach.getY() != nach.getY() +1){
                if(von.getY() != 6 || nach.getY() != 4) return false;
            }

            if(von.getX() != nach.getX()){
                //wenn endsposition nicht eins mehr oder eins weniger als ausgangsposition => zug ungültig
                if(nach.getX() -1 != von.getX() || nach.getX() +1 != von.getX()) return false;

                //wenn auf endposition keine figur steht => zug ungültig (ob figur gegner ist wird in Figur klasse geprüft)
                if(spielFeld.getFigur(nach.getX(), nach.getY()).getSymbol() == ' ') return false;
            }



        }

        return super.zugMöglich(spielFeld, von, nach);
    }
}