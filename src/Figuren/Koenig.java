package Figuren;

import Main.Position;
import Main.SpielFeld;

public class Koenig extends Figur {

	 public Koenig(boolean farbeWeiss){
	        this.farbeWeiss = farbeWeiss;
	        if(farbeWeiss){
	            this.symbol = 'k';
	        } else {
	            this.symbol = 'K';
	        }
	    }
	    public boolean zugMoeglich(SpielFeld spielFeld, Position von, Position nach) {

	        return super.zugMoeglich(spielFeld, von, nach);
	    }
	}