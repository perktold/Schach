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
        int deltaX, deltaY;

        deltaX = (von.getX() - nach.getX());
        if(deltaX < 0) deltaX = deltaX*-1;

        deltaY = (von.getY() - nach.getY());
        if(deltaY < 0) deltaY = deltaY*-1;

        if(farbeWeiß){

            //ein bauer darf nicht nach hinten oder nur auf die seite gehen
            if(von.getY() <= nach.getY()) return false;

            //ein bauer darf nur zwei nach vorne, wenn er auf zeile 7 steht
            if(von.getY() != nach.getY() +1){
                if(!(von.getY() == 6 && nach.getY() == 4)) return false;
            }

            if(von.getX() != nach.getX()){
                //wenn endsposition nicht eins mehr oder eins weniger als ausgangsposition => zug ungültig
                if(nach.getX() != von.getX()+1 && nach.getY() != von.getX()-1) return false;

                //wenn auf endposition keine figur steht => zug ungültig
                if(spielFeld.getFigur(nach.getX(), nach.getY()).getSymbol() == ' ') return false;
            }
        }

        if(!farbeWeiß){

            //ein bauer darf nicht nach hinten oder nur auf die seite gehen
            if(von.getY() >= nach.getY()) return false;

            //ein bauer darf nur zwei nach vorne, wenn er auf zeile 2 steht
            if(von.getY() != nach.getY() -1){
                if(!(von.getY() == 1 && nach.getY() == 3)) return false;
            }

            if(von.getX() != nach.getX()){
                //wenn endsposition X nicht eins mehr oder eins weniger als ausgangsposition => zug ungültig
                if(!(nach.getX() == von.getX()+1 || nach.getY() == von.getX()-1)) return false;

                //wenn auf endposition keine figur steht => zug ungültig
                if(spielFeld.getFigur(nach.getX(), nach.getY()).getSymbol() == ' ') return false;
            }
        }

        return super.zugMöglich(spielFeld, von, nach);
    }
}
