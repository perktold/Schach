package Figuren;

import Main.*;

public class Bauer extends Figur {
    public Bauer(boolean farbeWeiss){
        this.farbeWeiss = farbeWeiss;
        if(farbeWeiss){
            this.symbol = 'b';
        } else {
            this.symbol = 'B';
        }
    }

    //TODO: cleanup
    //ganz viel code smell hier aber bauern stinken halt
    public boolean zugMoeglich(SpielFeld spielFeld, Position von, Position nach) {
        int deltaX, deltaY;

        deltaX = Math.abs(von.getX() - nach.getX());
        deltaY = Math.abs(von.getY() - nach.getY());

        if(!farbeWeiss){

            //ein bauer darf nicht nach hinten oder nur auf die seite gehen
            if(von.getY() <= nach.getY()) return false;

            //ein schwarzer bauer darf nur zwei nach vorne, wenn er auf zeile 7 steht
            if(von.getY() != nach.getY() +1 ){
                if(!(von.getY() == 6 && nach.getY() == 4)) return false;
                //er darf keine figur überspringen
                if(spielFeld.getFigur(von.getX(), 5).symbol != ' ') return false;
            }
        }
        if(farbeWeiss){

            //ein bauer darf nicht nach hinten oder nur auf die seite gehen
            if(von.getY() >= nach.getY()) return false;

            //ein weißer bauer darf nur zwei nach vorne, wenn er auf zeile 2 steht
            if(von.getY() != nach.getY() -1){
                if(!(von.getY() == 1 && nach.getY() == 3)) return false;
                //er darf keine figur überspringen
                if(spielFeld.getFigur(von.getX(), 2).symbol != ' ') return false;
            }
        }

        if(von.getX() != nach.getX()){
            //wenn endsposition nicht eins mehr oder eins weniger als ausgangsposition => zug ungueltig
            if(!(nach.getX()+1 == von.getX() || nach.getY()-1 == von.getX())) return false;

            //wenn auf endposition keine figur steht => zug ungueltig
            if(spielFeld.getFigur(nach.getX(), nach.getY()).getSymbol() == ' ') return false;
        }else{
            //wenn auf endposition eine figur steht => zug ungueltig
            if(spielFeld.getFigur(nach.getX(), nach.getY()).getSymbol() != ' ') return false;
        }

        return super.zugMoeglich(spielFeld, von, nach);
    }
}
