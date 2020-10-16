package Figuren;

import Main.Position;
import Main.SpielFeld;

public class Turm  extends Figur{
    public Turm(boolean farbeweiss){
        this.farbeWeiss = farbeweiss;
        if(farbeweiss) {
            this.symbol = 't';
        } else {
            this.symbol = 'T';
        }
    }
    
    //TODO: fix Tower logic, cant move more than 3 fields up, down works
    public boolean zugMoeglich(SpielFeld spielFeld, Position von, Position nach) {
        if(von.getX() != nach.getX() && von.getY() != nach.getY()) return false;
        
       	//auf der x achse
        if(von.getX() == nach.getX()) {
        	
       		//von links nach rechts
        	if(von.getY()<nach.getY()) {
        		for(int y = von.getY()+1; y < nach.getY()-1; y++) {
        			if(spielFeld.getFigur(von.getX(), y).getSymbol()== ' ') {
        				
        			}
        		}
        	}
        	//von rechts nach links
        	if(von.getY()>nach.getY()) {
        		for(int y = nach.getY()+1; y < von.getY()-1; y--) {
        			if(spielFeld.getFigur(von.getX(), y).getSymbol()== ' ') {
        				
        			}
        			
        		}
        	}

        }
        return super.zugMoeglich(spielFeld, von, nach);
    }
}
