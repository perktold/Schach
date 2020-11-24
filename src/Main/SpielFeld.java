package Main;

import Figuren.*;

public class SpielFeld {
    private Figur[][] schachmatrix = new Figur[8][8];
    private boolean weissAmZug = true;
    private Frame frame;

	SpielFeld(Frame frame, Figur[][] schachmatrix){
		this.frame = frame;
		this.schachmatrix = schachmatrix;
	}
	
    public Figur getFigur(int x, int y){
        return schachmatrix[x][y];
    }
    
    public boolean getWeissAmZug() {
		return weissAmZug;
    }

    protected boolean spielZug(Position koordinatenFigur, Position nach){
        Figur figur = getFigur(koordinatenFigur.getX(), koordinatenFigur.getY());
        if(figur.zugMoeglich(this, koordinatenFigur, nach)) {
            move(koordinatenFigur, nach);
            figur.setBewegt();
            return true;
        }
        return false;

    }

    private void move(Position von, Position nach){
        schachmatrix[nach.getX()][nach.getY()] = schachmatrix[von.getX()][von.getY()];
        schachmatrix[von.getX()][von.getY()] = new Figur();
        weissAmZug = !weissAmZug;
    }

    public void ausgabe(){



//        +---+---+---+---+---+---+---+---+
//        |   |   |   |   |   |   |   |   |
//        +---+---+---+---+---+---+---+---+
//        |   |   |   |   |   |   |   |   |
//        +---+---+---+---+---+---+---+---+
//        |   |   |   |   |   |   |   |   |
//        +---+---+---+---+---+---+---+---+
//        |   |   |   |   |   |   |   |   |
//        +---+---+---+---+---+---+---+---+
//        |   |   |   |   |   |   |   |   |
//        +---+---+---+---+---+---+---+---+
//        |   |   |   |   |   |   |   |   |
//        +---+---+---+---+---+---+---+---+
//        |   |   |   |   |   |   |   |   |
//        +---+---+---+---+---+---+---+---+
//        |   |   |   |   |   |   |   |   |
//        +---+---+---+---+---+---+---+---+

        frame.fillWithSpaces();


        for(int x = 0; x < 8; x++){
            frame.set((4*x)+4, 0, (char)('a'+x));
        }

        for(int y = 0; y < 8; y++){
            frame.set(0, (y*2)+2, ((1+y)+"").toCharArray()[0]);

            for(int x = 0; x < 8; x++){
                frame.set((x*4)+2, (y*2)+2, '|');
            }

            frame.set(8*4+2, (y*2)+1, '+');
            frame.set(8*4+2, (y*2)+2, '|');

            for(int x = 0; x < 8; x++) {
                frame.set((4 * x) + 2, y*2+1, '+');
                frame.set((4 * x) + 3, y*2+1, '-');
                frame.set((4 * x) + 4, y*2+1, '-');
                frame.set((4 * x) + 5, y*2+1, '-');
            }
        }
        for(int x = 0; x < 8; x++) {
            frame.set((4 * x) + 2, 8 * 2+1, '+');
            frame.set((4 * x) + 3, 8 * 2+1, '-');
            frame.set((4 * x) + 4, 8 * 2+1, '-');
            frame.set((4 * x) + 5, 8 * 2+1, '-');
        }

        frame.set(4*8+2, 8*2+1, '+');
        
       

        for(int y = 0; y < schachmatrix.length; y++){
        	for(int x = 0; x < schachmatrix[y].length; x++){
                frame.set((4*x)+4, (y*2)+2, schachmatrix[x][y].getSymbol());
            }
        }
        frame.draw();
    }

   public boolean schach(){
        return false;
    }

    public boolean schachMatt(){
        return false;
    }
}
