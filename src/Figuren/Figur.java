package Figuren;
import Main.*;

public class Figur {
    char symbol;
    protected boolean farbeWeiß;
    public Figur(){
        this.symbol = ' ';
    }

    public boolean zugMöglich(SpielFeld feld, Koordinaten von, Koordinaten ziel) {


        if(von.equals(ziel)){
            return false;
        }
        if(feld.getFigur(von.getX(), von.getY()).getSymbol() == ' '){
            return false;
        }
        if(feld.getFigur(ziel.getX(), ziel.getY()).getSymbol() == ' '){
            return true;
        }
        else if(feld.getFigur(ziel.getX(), ziel.getY()).farbeWeiß == this.farbeWeiß){
            return false;
        }
        return true;
    }
    public boolean getFarbeWeiß(){
        return farbeWeiß;
    }
    public char getSymbol(){
        return symbol;
    }
}
