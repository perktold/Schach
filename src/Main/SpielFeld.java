package Main;

import Figuren.*;

public class SpielFeld {
    private Figur[][] schachmatrix = new Figur[8][8];
    private boolean weissAmZug = true;
    private Frame frame;

	SpielFeld(Frame frame){
        this.frame = frame;
        for(int i = 0; i < schachmatrix.length; i++){
            for(int j = 0; j < schachmatrix[i].length; j++){
                this.schachmatrix[i][j] = new Figur(); //nix gut
            }
        }

        this.schachmatrix[0][0] = new Turm(false);
        this.schachmatrix[7][0] = new Turm(false);
        this.schachmatrix[0][7] = new Turm(true);
        this.schachmatrix[7][7] = new Turm(true);

//        this.schachmatrix[2][0] = new Laeufer(false);
//        this.schachmatrix[5][0] = new Laeufer(false);
//        this.schachmatrix[2][7] = new Laeufer(true);
//        this.schachmatrix[5][7] = new Laeufer(true);

        this.schachmatrix[1][0] = new Springer(false);
        this.schachmatrix[6][0] = new Springer(false);
        this.schachmatrix[1][7] = new Springer(true);
        this.schachmatrix[6][7] = new Springer(true);

        this.schachmatrix[3][0] = new Dame(false);
        this.schachmatrix[3][7] = new Dame(true);


        for(int i = 0; i < schachmatrix[1].length; i++){
            this.schachmatrix[i][1] = new Bauer(false);
            this.schachmatrix[i][6] = new Bauer(true);
        }


    }

	SpielFeld(Frame frame, Figur[][] schachmatrix){
		this.frame = frame;
		this.schachmatrix = schachmatrix;
	}
	
    public Figur getFigur(int x, int y){
        return schachmatrix[x][y];
    }

    public boolean spielZug(Position koordinatenFigur, Position nach){
        Figur figur = getFigur(koordinatenFigur.getX(), koordinatenFigur.getY());

        if(figur.getSymbol() == ' ') return false;

        if(nach.getX() < 0 || nach.getX() > 7) return false;
        if(nach.getY() < 0 || nach.getY() > 7) return false;

        if(figur.getFarbeWeiss() != weissAmZug) return false;

        if(figur.zugMoeglich(this, koordinatenFigur, nach)) {
            move(koordinatenFigur, nach);
        }else return false;

        return true;
    }

    private void move(Position von, Position nach){
        schachmatrix[nach.getX()][nach.getY()] = schachmatrix[von.getX()][von.getY()];
        schachmatrix[von.getX()][von.getY()] = new Figur();
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
        
        //debug
        //TODO: find out wtf is going on here
        for(int y = 0; y < schachmatrix.length; y++){ 
        	for(int x = 0; x < schachmatrix[y].length; x++){
        		System.out.print(schachmatrix[y][x].getSymbol());
        	}
       		System.out.println();
        }
        //\debug

        for(int y = 0; y < 7; y++){ for(int x = 0; x < 7; x++){
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
