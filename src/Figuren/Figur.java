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
    	//if piece is empty
    	if(this.getSymbol() == ' ') return false;
    	
    	//if piece doesnt get moved
        if(von.equals(ziel))return false;
        
        //if piece is false color
        if(feld.getFigur(ziel.getX(), ziel.getY()).farbeWeiss == this.farbeWeiss) return false;
        
        //check if piece that gets moved is color of current player
        //if(this.getFarbeWeiss() != )
        return true;
    }
    
    public boolean getFarbeWeiss(){
        return farbeWeiss;
    }
    public char getSymbol(){
        return symbol;
    }
}
