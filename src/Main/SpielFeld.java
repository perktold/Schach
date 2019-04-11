package Main;

import Figuren.Bauer;
import Figuren.Figur;
import Figuren.Läufer;

public class SpielFeld {
    private Figur[][] schachmatrix = new Figur[8][8];
    private Frame frame;

    SpielFeld(Frame frame){
        this.frame = frame;
        for(int i = 0; i < schachmatrix.length; i++){
            for(int j = 0; j < schachmatrix[i].length; j++){
                this.schachmatrix[i][j] = new Figur();
            }
        }
        this.schachmatrix[7][7] = new Läufer(true);
        this.schachmatrix[0][0] = new Bauer(false);
    }

    public Figur getFigur(int x, int y){
        return schachmatrix[x][y];
    }

    public boolean spielZug(boolean weißAmZug, Koordinaten koordinatenFigur, Koordinaten nach){
        Figur figur = getFigur(koordinatenFigur.getX(), koordinatenFigur.getY());

        if(figur.getSymbol() == ' ') return false;

        if(nach.getX() < 0 || nach.getX() > 7) return false;
        if(nach.getY() < 0 || nach.getY() > 7) return false;

        if(figur.getFarbeWeiß() != weißAmZug) return false;

        if(figur.zugMöglich(this, koordinatenFigur, nach)) {
            swap(koordinatenFigur, nach);
        }

        return true;
    }

    private void swap(Koordinaten von, Koordinaten nach){
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

        for(int y = 0; y < 8; y++){ for(int x = 0; x < 8; x++){
                frame.set((4*x)+4, (y*2)+2, schachmatrix[x][y].getSymbol());
            }
        }
        frame.draw();
    }

   public boolean schach(){
        return false;
    }

    public boolean schachmatt(){
        return false;
    }

}
