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
        this.farbeWeiss = !Character.isUpperCase(symbol);

    	this.symbol = symbol;
    	this.bewegt = false;
    
    } 
    public boolean zugMoeglich(SpielFeld feld, Position von, Position ziel) {

        if(feld.getWeissAmZug() != this.getFarbeWeiss()) return false;

    	//if player tries to move empty field
    	if(this.getSymbol() == ' ') return false;
    	
    	//if piece doesnt get moved
        if(von.equals(ziel))return false;

        //if piece of same color is on destination field
        Figur zielfigur = feld.getFigur(ziel.getX(), ziel.getY());
        if(zielfigur.symbol != ' ' && zielfigur.farbeWeiss == this.farbeWeiss) return false;

        return true;
    }
    
    public boolean getFarbeWeiss(){
        return farbeWeiss;
    }
    public char getSymbol(){
        return symbol;
    }
}
