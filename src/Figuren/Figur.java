package Figuren;
import Main.*;

public class Figur {
    protected char symbol;
    protected boolean bewegt;
    protected boolean farbeWeiss;

    public Figur(){
    	this.symbol = ' ';
    	this.bewegt = false;
    }
    
    public Figur(char symbol) {
    	if(Character.isUpperCase(symbol)) {
    		this.farbeWeiss=false;
    	}else {
    		this.farbeWeiss=true;
    	}
    	this.symbol = symbol;
    	this.bewegt = false;
    }
    
    public boolean zugMoeglich(SpielFeld feld, Position von, Position ziel) {
    	
        if(von.equals(ziel)){
            return false;
        }
        if(feld.getFigur(von.getX(), von.getY()).getSymbol() == ' '){
            return false;
        }
        if(feld.getFigur(ziel.getX(), ziel.getY()).getSymbol() == ' '){
            return true;
        }
        else if(feld.getFigur(ziel.getX(), ziel.getY()).farbeWeiss == this.farbeWeiss){
            return false;
        }
        return true;
    }
    public boolean getFarbeWeiss(){
        return farbeWeiss;
    }
    public char getSymbol(){
        return symbol;
    }
}
