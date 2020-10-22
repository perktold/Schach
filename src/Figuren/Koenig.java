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
	    	 int deltaX, deltaY;
	    	 deltaX = Math.abs(nach.getX() - von.getX());
	         deltaY = Math.abs(nach.getY() - von.getY());
	         
	         if(deltaX == 1 && deltaY == 1) {
	         }else if(deltaX + deltaY > 1)return false;

	        return super.zugMoeglich(spielFeld, von, nach);
	    }
	}