package Figuren;

public class Springer extends Figur {
    Springer(boolean farbeweiß){
         if(farbeWeiß){
            this.symbol = 's';
        } else {
            this.symbol = 'S';
        }
        this.farbeWeiß = farbeWeiß;
    }
}
