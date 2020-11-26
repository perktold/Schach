package Figuren;

import Main.*;


public class Laeufer extends Figur {
    public Laeufer(boolean farbeWeiss){
        this.farbeWeiss = farbeWeiss;
        if(farbeWeiss){
            this.symbol = 'l';
        } else {
            this.symbol = 'L';
        }
    }
    
    public boolean zugMoeglich(SpielFeld spielFeld, Position von, Position nach) {
        int diffX, diffY;
        int deltaX, deltaY, delta;

        diffX = (nach.getX() - von.getX());
        deltaX = Math.abs(diffX);

        diffY = (nach.getY() - von.getY());
        deltaY = Math.abs(diffY);

        //muss diagonal laufen
        if(deltaX != deltaY) return false;
        delta = deltaX;

        if(diffX*diffY > 0) {
            for (int i = 0; i != delta; i += diffX>0?1:-1) {
                //skip von/nach Fields (they are supposed to have chesspieces on them)
                if(i==0 || von.getX()+i == nach.getX()) continue;
                if (spielFeld.getFigur(von.getX() + i, von.getY() + i).getSymbol() != ' ') return false;
            }
        }else{
            for(int i = 0; i != delta; i += diffX>0?1:-1){
                if (spielFeld.getFigur(von.getX() + i, von.getY() - i).getSymbol() != ' ') return false;
            }
        }

        return super.zugMoeglich(spielFeld, von, nach);
    }

}